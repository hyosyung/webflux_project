package com.example.jayden.controller;

import com.example.jayden.model.dto.ReviewRequestDto;
import com.example.jayden.model.dto.ReviewWithProductDto;
import com.example.jayden.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping(value = "/review", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ReviewWithProductDto> saveReview(@RequestBody ReviewRequestDto request) {
        return reviewService.saveReview(request);
    }

    @DeleteMapping("/product/{productId}/review/{reviewId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<ServerResponse> deleteReview(@PathVariable Integer productId, @PathVariable Integer reviewId) {
        return reviewService.deleteReview(productId, reviewId);
    }
}
