package com.example.jayden.model.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductRequestDto {
    private String name;
    private Integer price;
}
