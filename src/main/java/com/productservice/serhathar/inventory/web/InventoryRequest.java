package com.productservice.serhathar.inventory.web;

import com.productservice.serhathar.inventory.api.InventoryDto;
import com.productservice.serhathar.product.api.ProductDto;
import com.productservice.serhathar.product.api.ProductService;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InventoryRequest {

    private String name;
    private List<ProductDto> productList;

    public InventoryDto toDto() {
        return InventoryDto.builder()
                .name(name)
                .productList(ProductService.toProductList(productList))
                .build();
    }
}
