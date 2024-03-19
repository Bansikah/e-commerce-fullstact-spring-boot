package com.bansikah.ecommerce.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@DynamicUpdate
@DynamicInsert
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    private int quantity;
    private BigDecimal pricePerUnit;


}
