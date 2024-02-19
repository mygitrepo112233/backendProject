package com.productservice.serhathar.category.web;

import com.productservice.serhathar.category.api.CategoryDto;
import com.productservice.serhathar.category.api.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping(path = "/add")
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request) {
        CategoryDto category = categoryService.createCategory(request.toDto());
        return ResponseEntity.ok(CategoryResponse.toResponse(category));
    }
    @GetMapping(path = "/get-all")
    public ResponseEntity<List<CategoryResponse>> getAllCategory() {
        List<CategoryResponse> categoryResponseList = toResponse(categoryService.getAllCategory());
        return ResponseEntity.ok(categoryResponseList);
    }
    @GetMapping(path = "/get-active")
    public ResponseEntity<List<CategoryResponse>> getActiveCategories() {
        List<CategoryResponse> categoryResponseList = toResponse(categoryService.findByStatusTrue());
        return ResponseEntity.ok(categoryResponseList);
    }
    @PutMapping(path = "/get/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable(value = "id") String id, @Valid @RequestBody CategoryDto dto) {
        CategoryDto category = categoryService.updateCategory(id, dto);
        return ResponseEntity.ok(CategoryResponse.toResponse(category));
    }
    @PutMapping(path = "/delete-status/{id}")
    public void delete_statusCategory(@PathVariable(value = "id") String id, CategoryDto dto) {
        categoryService.deleteCategory(id);
    }
    @DeleteMapping(path = "/delete/{id}")
    void delete(@PathVariable String id) {
        //categoryService.deleteCategory(id);
    }
    public List<CategoryResponse> toResponse(List<CategoryDto> categoryDtoList) {
        return categoryDtoList.stream().map(CategoryResponse::toResponse).toList();
    }
}

/*
    @PutMapping//"/{categoryId}/category/{productId}/add")
    public void addProductToCategory(@PathVariable String categoryId, @PathVariable String productId) {
        categoryService.addProductToCategory(categoryId, productId);
    }

    @PutMapping//"/{categoryId}/category/{productId}/remove"
    public void removeProductFromCategory(@PathVariable String categoryId, @PathVariable String productId) {
        categoryService.removeProductFromCategory(categoryId, productId);
    }*/