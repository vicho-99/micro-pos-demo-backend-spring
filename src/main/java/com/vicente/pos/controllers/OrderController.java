package com.vicente.pos.controllers;

import com.vicente.pos.models.OrderModel;
import com.vicente.pos.models.Response;
import com.vicente.pos.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {

        this.orderService = orderService;
    }

    @GetMapping("/")
    public List<OrderModel> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/")
    public ResponseEntity<Response> createCategory(@RequestBody OrderModel order){
        orderService.createOrder(order);
        return Response.res("Successfully created", HttpStatus.CREATED);
    }
}
