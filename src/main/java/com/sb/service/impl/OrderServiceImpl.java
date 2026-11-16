package com.sb.service.impl;

import com.sb.builder.OrderBuilder;
import com.sb.dao_repo.ItemRepository;
import com.sb.dao_repo.OrderRepository;
import com.sb.dto.orderitems.NewOrderItemRequestDTO;
import com.sb.dto.orders.NewOrderRequestDTO;
import com.sb.dto.orders.OrderResponseDTO;
import com.sb.model.Item;
import com.sb.model.Order;
import com.sb.model.OrderItem;
import com.sb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemRepository itemRepository;

    public OrderResponseDTO placedOrder(NewOrderRequestDTO newOrderRequestDTO){

        Order order = OrderBuilder.buildOrderFromOrderRequestDTO(newOrderRequestDTO);

        List<NewOrderItemRequestDTO> orderItemRequestDTOs = newOrderRequestDTO.getOrderItemRequestDTOs();
        List<OrderItem> orderItems = order.getOrderItems();

        for (int i = 0; i < orderItemRequestDTOs.size(); i++) {

            long itemId = orderItemRequestDTOs.get(i).getItemId();
            Item item = itemRepository.findById(itemId).get();

            orderItems.get(i).setItem(item);
            orderItems.get(i).setOrder(order);

        }

        Order savedOrder = orderRepository.save(order);
        OrderResponseDTO orderResponseDTO = OrderBuilder.buildOrderResponseDTOFromOrder(savedOrder);

        return orderResponseDTO;
    }
}
