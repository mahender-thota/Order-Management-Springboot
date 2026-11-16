package com.sb.service;

import com.sb.dto.orders.NewOrderRequestDTO;
import com.sb.dto.orders.OrderResponseDTO;

public interface OrderService {

    public OrderResponseDTO placedOrder(NewOrderRequestDTO newOrderRequestDTO);
}
