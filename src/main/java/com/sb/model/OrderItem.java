package com.sb.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderitems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderItemId;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private double orderItemPrice;
    private double orderItemQuantity;
    private int discount;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderItem(Item item, double orderItemPrice, double orderItemQuantity, int discount, Order order) {
        this.item = item;
        this.orderItemPrice = orderItemPrice;
        this.orderItemQuantity = orderItemQuantity;
        this.discount = discount;
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", orderItemPrice=" + orderItemPrice +
                ", orderItemQuantity=" + orderItemQuantity +
                ", discount=" + discount +
                '}';
    }
}
