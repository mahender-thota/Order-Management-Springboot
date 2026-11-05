package com.sb.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    private String name;
    private LocalDate dateOfOrder;
    private int numberOfItems;
    private double totalPrice;
    private String orderStatus;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    public Order(String name, LocalDate dateOfOrder, int numberOfItems, double totalPrice, String orderStatus, List<OrderItem> orderItems) {
        this.name = name;
        this.dateOfOrder = dateOfOrder;
        this.numberOfItems = numberOfItems;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", name='" + name + '\'' +
                ", dateOfOrder=" + dateOfOrder +
                ", numberOfItems=" + numberOfItems +
                ", totalPrice=" + totalPrice +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
