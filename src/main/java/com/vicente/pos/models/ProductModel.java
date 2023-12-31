package com.vicente.pos.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Product", schema = "public")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(updatable = false, insertable = false)
    @JsonFormat(pattern = "dd-MMM-yyyy HH:mm:ss", timezone = "America/Santiago")
    private Timestamp created;
    @JsonProperty("isActive")
    private boolean isActive;
    @Column(nullable = false)
    private String name;
    private String description;

    private BigDecimal  stock;

    private BigDecimal price;

    private String photoUrl;

    private Integer categoryId;
    @Column(unique=true)
    private String lectureCode;

}
