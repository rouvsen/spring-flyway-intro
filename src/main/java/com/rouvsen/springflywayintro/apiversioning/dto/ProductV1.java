package com.rouvsen.springflywayintro.apiversioning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductV1 {
    private Long id;
    private String name;
}
