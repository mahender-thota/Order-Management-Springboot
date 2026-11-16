package com.sb.dto.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseDTO {

    private long itemId;
    private String itemName;
    private String catagory;
    private double price;
    private String brand;
    private int quantity;
    private int discount;
    private double rating;
}
