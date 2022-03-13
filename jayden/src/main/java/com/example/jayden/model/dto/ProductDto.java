package com.example.jayden.model.dto;

import com.example.jayden.model.Product;
import com.example.jayden.model.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    private Integer id;
    private String name;
    private Integer price;
    private List<ReviewDto> reviews = Collections.emptyList();

    public static ProductDto of(Product product, List<Review> reviews){
        if(product == null){
            return null;
        }
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        if(CollectionUtils.isEmpty(reviews)){
            return dto;
        }
        dto.setReviews(
                reviews.stream()
                        .filter(Objects::nonNull)
                        .map(ReviewDto::of)
                        .collect(Collectors.toList())
        );
        return dto;
    }
}
