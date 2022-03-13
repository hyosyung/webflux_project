package com.example.jayden.service;

import com.example.jayden.model.Product;
import com.example.jayden.model.Review;
import com.example.jayden.model.dto.ProductDto;
import com.example.jayden.model.dto.ProductRequestDto;
import com.example.jayden.repository.ProductRepository;
import com.example.jayden.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public Flux<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .flatMap(this::mergeWithReview);
    }

    public Mono<ProductDto> saveProduct(ProductRequestDto request){
        return productRepository.save(Product.of(request))
                .flatMap(this::mergeWithReview);
    }

    public Mono<ProductDto> getProduct(Integer id){
        return productRepository.findById(id)
                .flatMap(this::mergeWithReview);
    }

    public Mono<ProductDto> updateProduct(Integer id, ProductRequestDto requestDto) {
        return productRepository.findById(id)
                .map(p -> {
                    p.setInfo(requestDto);
                    return p;
                })
                .flatMap(productRepository::save)
                .flatMap(this::mergeWithReview);
    }

    public Mono<Boolean> deleteProduct(Integer id) {
        return productRepository.deleteById(id)
                .then(reviewRepository.deleteReviewByProductId(id));
    }

    private Mono<ProductDto> mergeWithReview(Product product){
        return reviewRepository.findReviewByProductId(product.getId())
                .collectList()
                .map(reviews -> ProductDto.of(product,reviews));
    }
}
