package com.example.jayden.model;

import com.example.jayden.model.dto.ReviewRequestDto;
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

    public static Review of(ReviewRequestDto request){
        if(request == null){
            return null;
        }
        Review review = new Review();
        review.setContent(request.getContent());
        review.setProductId(request.getProductId());
        return review;
    }
}
