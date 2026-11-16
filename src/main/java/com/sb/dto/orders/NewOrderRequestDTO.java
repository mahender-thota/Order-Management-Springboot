package com.sb.dto.orders;

import com.sb.dto.orderitems.NewOrderItemRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewOrderRequestDTO {

    private String name;
    private int numberOfItems;
    private double totalPrice;
    private List<NewOrderItemRequestDTO> orderItemRequestDTOs;
}
