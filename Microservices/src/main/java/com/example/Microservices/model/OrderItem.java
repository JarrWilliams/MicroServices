package com.example.Microservices.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OrderItems")
public class OrderItem {

//    public OrderItem(int productName, int quantity) {
//        this.productName = productName;
//        this.quantity = quantity;
//    }
//
//    @Id
//    @SequenceGenerator(
//            name = "orderItem_sequence",
//            sequenceName = "orderItem_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "orderItem_sequence"
//    )
//    private long id;
    private int productName;
    private int quantity;

    public int getProduct() {
        return productName;
    }

    public void setProduct(int productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product=" + productName +
                ", quantity=" + quantity +
                '}';
    }
}
