package com.sb.builder;

import com.sb.constants.OrderStatus;
import com.sb.dto.orderitems.NewOrderItemRequestDTO;
import com.sb.dto.orderitems.OrderItemResponseDTO;
import com.sb.dto.orders.NewOrderRequestDTO;
import com.sb.dto.orders.OrderResponseDTO;
import com.sb.model.Order;
import com.sb.model.OrderItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {

    public static Order buildOrderFromOrderRequestDTO(NewOrderRequestDTO orderRequestDTO) {

        List<NewOrderItemRequestDTO> orderItemRequestDTOs = orderRequestDTO.getOrderItemRequestDTOs();
        List<OrderItem> orderItemsList = new ArrayList<>();

        for (NewOrderItemRequestDTO item : orderItemRequestDTOs) {
            OrderItem orderItem = OrderItemBuilder.buildOrderItemFromOrderItemRequestDTO(item);
            orderItemsList.add(orderItem);
        }

        return Order.builder()
                .name(orderRequestDTO.getName())
                .numberOfItems(orderRequestDTO.getNumberOfItems())
                .totalPrice(orderRequestDTO.getTotalPrice())
                .dateOfOrder(LocalDate.now())
                .orderStatus(OrderStatus.PLACED)
                .orderItems(orderItemsList)
                .build();
    }



    public static OrderResponseDTO buildOrderResponseDTOFromOrder(Order order) {

        List<OrderItemResponseDTO> orderItemResponseDTOList = new ArrayList<>();
        List<OrderItem> orderItems = order.getOrderItems();

        for (OrderItem item : orderItems) {
            OrderItemResponseDTO orderItemResponseDTO = OrderItemBuilder.buildOrderItemResponseDTOFromOrderItem(item);
            orderItemResponseDTOList.add(orderItemResponseDTO);
        }

        return OrderResponseDTO.builder()
                .orderId(order.getOrderId())
                .numberOfItems(order.getNumberOfItems())
                .totalPrice(order.getTotalPrice())
                .dateOfOrder(order.getDateOfOrder())
                .orderStatus(order.getOrderStatus())
                .name(order.getName())
                .orderItemResponseDTOS(orderItemResponseDTOList)
                .build();
    }

}
