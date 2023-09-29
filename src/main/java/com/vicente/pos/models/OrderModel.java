package com.vicente.pos.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="order", schema = "public")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column(updatable = false, insertable = false)
    @JsonFormat(pattern = "dd-MMM-yyyy HH:mm:ss", timezone = "America/Santiago")
    private Timestamp created;

    @Column(updatable = false, insertable = false, name = "created")
    @JsonFormat(pattern = "dd-MMM-yyyy", timezone = "America/Santiago")
    private Timestamp createdDate;

    private int totalItem;

    private BigDecimal totalAmount;

    private String paymentMethod;

    @OneToMany(mappedBy = "order")
    private List<OrderLineModel> items;

}
