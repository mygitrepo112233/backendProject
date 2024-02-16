package com.productservice.serhathar.inventory.api;

import com.productservice.serhathar.product.impl.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class InventoryDto {

    //every inventory is uniq for every user
    private String id;
    private String name;
    private List<Product> productList;
}
