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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Category", schema = "public")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    private String name;

    @Column(updatable = false, insertable = false)
    @JsonFormat(pattern = "dd-MMM-yyyy HH:mm:ss", timezone = "America/Santiago")
    private Timestamp created;
    @JsonProperty("isActive")
    private boolean isActive;

    @Column(updatable = false, insertable = false)
    private BigDecimal totalSalesAmount;

    @Column(updatable = false, insertable = false)
    private BigDecimal totalSalesQty;

}
