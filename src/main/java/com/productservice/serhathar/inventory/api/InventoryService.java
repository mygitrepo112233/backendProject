package com.productservice.serhathar.inventory.api;

import com.productservice.serhathar.inventory.impl.Inventory;
import com.productservice.serhathar.inventory.impl.InventoryRepository;

import java.util.List;

public interface InventoryService {
    InventoryDto createInventory(InventoryDto inventoryDto);

    List<InventoryDto> getAllInventory();

    Inventory getById(String id);

    InventoryRepository updateInventory(String id, InventoryDto dto);
}
