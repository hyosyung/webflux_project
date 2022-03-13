package com.example.jayden.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Review {
    @Id
    private Integer id;
    private String content;
    private Integer productId;
}
