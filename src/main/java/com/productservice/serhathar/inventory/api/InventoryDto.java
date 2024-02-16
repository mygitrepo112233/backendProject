package com.productservice.serhathar.inventory.api;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InventoryDto {

    //every inventory is uniq for every user
    private String id;
    private String name;
}
