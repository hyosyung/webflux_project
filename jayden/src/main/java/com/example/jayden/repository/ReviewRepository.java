package com.example.jayden.repository;

import com.example.jayden.model.Review;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ReviewRepository extends ReactiveCrudRepository<Review, Integer> {
    Flux<Review> findReviewByProductId(Integer productId);

    Mono<Void> deleteReviewByProductId(Integer productId);

    Flux<Void> deleteReviewByProductIdAndId(Integer productId, Integer reviewId);
}
