package com.example.jayden.model;


import com.example.jayden.model.dto.ProductRequestDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Product {
    @Id
    private Integer id;
    private String name;
    private Integer price;

    public static Product of(ProductRequestDto requestDto){
        if(requestDto == null){
            return null;
        }
        Product product = new Product();
        product.setName(requestDto.getName());
        product.setPrice(requestDto.getPrice());
        return product;
    }

    public void setInfo(ProductRequestDto requestDto){
        if(requestDto == null){
            return;
        }
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }
}
