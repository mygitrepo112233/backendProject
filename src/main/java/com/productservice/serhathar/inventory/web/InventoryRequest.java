package com.productservice.serhathar.inventory.web;

import com.productservice.serhathar.inventory.api.InventoryDto;
import com.productservice.serhathar.product.impl.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InventoryRequest {

    private List<Product> productList;
    public InventoryDto toDto() {
        return InventoryDto.builder()
                .productList(productList)
                .build();
    }
}
