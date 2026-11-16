package com.sb.controller;

import com.sb.dto.orders.NewOrderRequestDTO;
import com.sb.dto.orders.OrderResponseDTO;
import com.sb.model.Order;
import com.sb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/new")
    public OrderResponseDTO placeOrder(@RequestBody NewOrderRequestDTO orderRequestDTO){
        return orderService.placedOrder(orderRequestDTO);
    }
}
