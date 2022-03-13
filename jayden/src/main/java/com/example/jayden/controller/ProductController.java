package com.example.jayden.controller;

import com.example.jayden.model.dto.ProductDto;
import com.example.jayden.model.dto.ProductRequestDto;
import com.example.jayden.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductDto> saveProduct(@RequestBody ProductRequestDto request){
        return productService.saveProduct(request);
    }

    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductDto> getProduct(@PathVariable Integer id){
        return productService.getProduct(id);
    }

    @PutMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductDto> updateProduct(@PathVariable Integer id, @RequestBody ProductRequestDto request){
        return productService.updateProduct(id, request);
    }

    @DeleteMapping("/product/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Boolean> deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }
}
