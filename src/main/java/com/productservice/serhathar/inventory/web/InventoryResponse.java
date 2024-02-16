package com.productservice.serhathar.inventory.web;

import com.productservice.serhathar.inventory.api.InventoryDto;
import com.productservice.serhathar.product.impl.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InventoryResponse {

    private String id;
    private List<Product> productList;

    public static InventoryResponse toResponse(InventoryDto dto) {
        return InventoryResponse.builder()
                .id(dto.getId())
                .productList(dto.getProductList())
                .build();
    }
}
