package com.productservice.serhathar.inventory.impl;

import com.productservice.serhathar.inventory.api.InventoryDto;
import com.productservice.serhathar.inventory.api.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService {

    @Override
    public InventoryDto createInventory(InventoryDto inventoryDto) {
        return null;
    }

    @Override
    public Inventory getById(String id) {
        return null;
    }

    @Override
    public InventoryRepository updateInventory(String id, InventoryDto dto) {
        return null;
    }
}
