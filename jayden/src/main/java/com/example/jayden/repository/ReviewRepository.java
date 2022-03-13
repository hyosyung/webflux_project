package com.example.jayden.repository;

import com.example.jayden.model.Review;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReviewRepository extends ReactiveCrudRepository<Review,Integer> {
}
