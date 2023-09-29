package com.vicente.pos.services;

import com.vicente.pos.models.OrderLineModel;
import com.vicente.pos.models.OrderModel;
import com.vicente.pos.models.ProductModel;
import com.vicente.pos.repositories.OrdenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    private final OrdenRepository ordenRepository;
    private final OrderLineService orderLineService;
    private final ProductService productService;


    @Autowired
    public OrderService(OrdenRepository ordenRepository, OrderLineService orderLineService, ProductService productService) {

        this.ordenRepository = ordenRepository;
        this.orderLineService = orderLineService;
        this.productService = productService;
    }


    public List<OrderModel> getAllOrders() {

        return ordenRepository.findAll(Sort.by("created").descending());
    }

    public  BigDecimal calculateTotal(List<OrderLineModel> orderLine){
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (int y = 0; y < orderLine.size() ; y++) {
            OrderLineModel item = orderLine.get(y);
            ProductModel  product = productService.getProductById(item.getProduct().getProductId());
            BigDecimal totalLine = product.getPrice().multiply(item.getQty());
            totalAmount = totalAmount.add(totalLine);
        }
        return totalAmount;
    }

    public void createOrder(OrderModel order){

        BigDecimal totalAmount = calculateTotal(order.getItems());

        System.out.println(totalAmount);

        order.setTotalAmount(totalAmount);
        order.setTotalItem(order.getItems().size());

        OrderModel savedOrder = ordenRepository.save(order);

        for (int i = 0; i < order.getItems().size() ; i++) {
            OrderLineModel orderLine = order.getItems().get(i);
            ProductModel  product = productService.getProductById(orderLine.getProduct().getProductId());
            orderLine.setPrice(product.getPrice());
            orderLine.setOrder(savedOrder);
            orderLineService.createOrderLine(orderLine);
            BigDecimal newStock =  product.getStock().subtract( orderLine.getQty());
            product.setStock(newStock);
            productService.updateProduct(product);

        }

    }

}