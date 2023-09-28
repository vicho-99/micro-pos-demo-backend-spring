package com.vicente.pos.services;

import com.vicente.pos.models.OrderLineModel;
import com.vicente.pos.repositories.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;

    @Autowired
    public OrderLineService(OrderLineRepository orderLineRepository) {

        this.orderLineRepository = orderLineRepository;

    }

    public void createOrderLine(OrderLineModel orderLine){

        orderLineRepository.save(orderLine);

    }



}
