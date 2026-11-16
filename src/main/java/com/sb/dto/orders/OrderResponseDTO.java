package com.sb.dto.orders;

import com.sb.constants.OrderStatus;
import com.sb.dto.orderitems.OrderItemResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDTO {

    private long orderId;
    private String name;
    private LocalDate dateOfOrder;
    private int numberOfItems;
    private double totalPrice;
    private OrderStatus orderStatus;
    private List<OrderItemResponseDTO> orderItemResponseDTOS;
}
