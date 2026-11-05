package com.sb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;

    @Column(nullable = false)
    private String itemName;

    private String catagory;

    @Column(nullable = false)
    private double price;
    private String brand;
    private int quantity;
    private int discount;
    private double rating;

    public Item(String itemName, String catagory, double price, String brand, int quantity, int discount, double rating) {
        this.itemName = itemName;
        this.catagory = catagory;
        this.price = price;
        this.brand = brand;
        this.quantity = quantity;
        this.discount = discount;
        this.rating = rating;
    }

    public Item(String itemName, double price, String brand, int quantity, int discount, double rating) {
        this.itemName = itemName;
        this.price = price;
        this.brand = brand;
        this.quantity = quantity;
        this.discount = discount;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", catagory='" + catagory + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                ", discount=" + discount +
                ", rating=" + rating +
                '}';
    }
}
