package com.sb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequestDTO {

    private String itemName;
    private String catagory;
    private double price;
    private String brand;
    private int quantity;
    private int discount;

}
