package com.rouvsen.springflywayintro.apiversioning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductV2 {
    private Long id;
    private String name;
    private BigDecimal price;
}
