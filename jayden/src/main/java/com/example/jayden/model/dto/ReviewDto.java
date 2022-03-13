package com.example.jayden.model.dto;

import com.example.jayden.model.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewDto {
    private Integer id;
    private String content;

    public static ReviewDto of(Review review){
        if(review == null){
            return null;
        }
        ReviewDto dto = new ReviewDto();
        dto.setId(review.getId());
        dto.setContent(review.getContent());
        return dto;
    }
}
