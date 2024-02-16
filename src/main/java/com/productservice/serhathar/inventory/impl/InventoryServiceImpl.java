package com.productservice.serhathar.inventory.impl;

import com.productservice.serhathar.inventory.api.InventoryDto;
import com.productservice.serhathar.inventory.api.InventoryService;
import com.productservice.serhathar.product.impl.Product;
import com.productservice.serhathar.product.impl.ProductServiceImpl;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository repository;
    private final ProductServiceImpl productService;

    @Override
    @Transactional
    public InventoryDto createInventory(InventoryDto inventoryDto) {
        checkInventoryExists(inventoryDto);
        Inventory inventory = toEntity(inventoryDto);
        return toDto(repository.save(inventory));
    }

    @Override
    public List<InventoryDto> getAllInventory() {
        return repository.findAll().stream().map(this::toDto).toList();
        //repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Inventory getById(String id) {
        return repository.getInventoryById(id);
    }

    @Override
    public InventoryRepository updateInventory(String id, InventoryDto dto) {
        return null;
    }

    public void addProductToInventory(String inventoryId, String productId) {
        Inventory inventory = repository.getInventoryById(inventoryId);
        Product product = productService.getProductById(productId);
        inventory.getProductList().add(product);
        repository.save(inventory);
    }

    public void removeProductFromInventory(String inventoryId, String productId) {
        Inventory inventory = repository.getInventoryById(inventoryId);
        Product product = productService.getProductById(productId);
        inventory.getProductList().remove(product);
        repository.save(inventory);
    }

    private void checkInventoryExists(InventoryDto dto) {
        repository.findByName(dto.getName()).ifPresent(Inventory -> {
            throw new EntityExistsException(
                    String.format("Entity %s already exists", Inventory.getClass().getName())
            );
        });
    }

    private Inventory checkInventoryUpdate(InventoryDto dto, Inventory inventory) {
        inventory.setName(dto.getName() == null ? inventory.getName() : dto.getName());
        inventory.setProductList(dto.getProductList() == null ? inventory.getProductList() : dto.getProductList());
        inventory.setName(dto.getName() == null ? inventory.getName() : dto.getName());
        return inventory;
    }

    private Inventory toEntity(InventoryDto dto) {
        Inventory inventory = new Inventory();
        inventory.setName(dto.getName());
        inventory.setProductList(dto.getProductList());
        return inventory;
    }

    private InventoryDto toDto(Inventory inventory) {
        return InventoryDto.builder()
                .id(inventory.getId())
                .productList(inventory.getProductList())
                .name(inventory.getName())
                .build();
    }
}
