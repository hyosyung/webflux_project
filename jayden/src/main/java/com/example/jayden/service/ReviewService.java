package com.example.jayden.service;

import com.example.jayden.model.Review;
import com.example.jayden.model.dto.ReviewRequestDto;
import com.example.jayden.model.dto.ReviewWithProductDto;
import com.example.jayden.repository.ProductRepository;
import com.example.jayden.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewService {
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public Mono<ReviewWithProductDto> saveReview(ReviewRequestDto requestDto) {
        return reviewRepository.save(Review.of(requestDto))
                .flatMap(this::mergeWithProduct);
    }

    public Mono<ServerResponse> deleteReview(Integer productId, Integer reviewId) {
        return reviewRepository.deleteReviewByProductIdAndId(productId, reviewId).then(ServerResponse.noContent().build());
    }

    private Mono<ReviewWithProductDto> mergeWithProduct(Review review) {
        return productRepository.findById(review.getProductId())
                .map(p -> ReviewWithProductDto.of(review, p));
    }

}
