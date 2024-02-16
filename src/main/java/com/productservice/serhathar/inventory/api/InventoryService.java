package com.productservice.serhathar.inventory.api;

import com.productservice.serhathar.inventory.impl.Inventory;
import com.productservice.serhathar.inventory.impl.InventoryRepository;

public interface InventoryService {
    InventoryDto createInventory(InventoryDto inventoryDto);
    Inventory getById(String id);
    InventoryRepository updateInventory(String id, InventoryDto dto);
}
