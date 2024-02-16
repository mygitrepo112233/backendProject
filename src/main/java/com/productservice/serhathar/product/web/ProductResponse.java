package com.productservice.serhathar.product.web;

import com.productservice.serhathar.category.api.CategoryDto;
import com.productservice.serhathar.product.api.ProductDto;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class ProductResponse {
    private String id;
    private String barcode;
    private Date creaDate;
    private String name;
    private String brand;
    private BigDecimal price;
    private String categoryName;
    private Boolean status;
    private CategoryDto category;

    public static ProductResponse toResponse(ProductDto dto){
        return ProductResponse.builder()
                .id(dto.getId())
                .status(dto.getStatus())
                .barcode(dto.getBarcode())
                .creaDate(dto.getCreaDate())
                .name(dto.getName())
                .brand(dto.getBrand())
                .categoryName(dto.getCategoryName())
                .price(dto.getPrice())
                .category(dto.getCategory())
                .build();
    }
}