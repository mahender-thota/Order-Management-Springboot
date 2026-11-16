package com.sb.builder;

import com.sb.dto.orderitems.NewOrderItemRequestDTO;
import com.sb.dto.orderitems.OrderItemResponseDTO;
import com.sb.model.OrderItem;

public class OrderItemBuilder {

    public static OrderItem buildOrderItemFromOrderItemRequestDTO(NewOrderItemRequestDTO orderItemRequestDTO) {

        return OrderItem.builder()
                .orderItemQuantity(orderItemRequestDTO.getOrderItemQuantity())
                .orderItemPrice(orderItemRequestDTO.getOrderItemPrice())
                .discount(orderItemRequestDTO.getDiscount())
                .build();
    }

    public static OrderItemResponseDTO buildOrderItemResponseDTOFromOrderItem(OrderItem orderItem){
        return OrderItemResponseDTO.builder()
                .orderItemId(orderItem.getOrderItemId())
                .orderItemPrice(orderItem.getOrderItemPrice())
                .orderItemQuantity(orderItem.getOrderItemQuantity())
                .discount(orderItem.getDiscount())
                .itemId(orderItem.getItem().getItemId())
                .itemName(orderItem.getItem().getItemName())
                .build();

    }
}
