package com.productservice.serhathar.inventory.api;

import com.productservice.serhathar.inventory.impl.Inventory;
import com.productservice.serhathar.inventory.impl.InventoryRepository;

import java.util.List;

public interface InventoryService {
    InventoryDto createInventory(InventoryDto inventoryDto);
    List<InventoryDto> getAllInventories();
    Inventory getById(String id);
    InventoryRepository updateInventory(String id, InventoryDto dto);
    public void addProductToInventory(String inventoryId, String productId);
    public void removeProductFromInventory(String inventoryId, String productId);

}
