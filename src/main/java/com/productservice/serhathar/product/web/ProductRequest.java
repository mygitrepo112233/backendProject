package com.productservice.serhathar.product.web;

import com.productservice.serhathar.category.api.CategoryDto;
import com.productservice.serhathar.product.api.ProductDto;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class ProductRequest {
    private final String name;
    private final String brand;
    private final BigDecimal price;
    private final String categoryName;
    private final String barcode;
    private final Boolean status;

    public ProductDto toDto() {
        return ProductDto.builder()
                .name(name)
                .brand(brand)
                .status(status)
                .price(price)
                .categoryName(categoryName)
                .barcode(barcode)
                .build();
    }
}