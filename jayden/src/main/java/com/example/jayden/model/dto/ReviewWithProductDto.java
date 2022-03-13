package com.example.jayden.model.dto;

import com.example.jayden.model.Product;
import com.example.jayden.model.Review;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ReviewWithProductDto {
    private Integer id;
    private String content;
    private Product product;

    public static ReviewWithProductDto of(Review review, Product product) {
        if (review == null) {
            return null;
        }
        ReviewWithProductDto dto = new ReviewWithProductDto();
        dto.setId(review.getId());
        dto.setContent(review.getContent());
        dto.setProduct(product);
        return dto;
    }
}
