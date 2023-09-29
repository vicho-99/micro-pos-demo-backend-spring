package com.vicente.pos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="order_line", schema = "public")
public class OrderLineModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderLineId;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    @JsonIgnore

    private OrderModel order;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel product;

    private BigDecimal qty;

    private BigDecimal price;


}
