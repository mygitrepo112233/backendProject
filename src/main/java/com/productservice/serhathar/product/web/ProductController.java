package com.productservice.serhathar.product.web;

import com.productservice.serhathar.product.api.ProductDto;
import com.productservice.serhathar.product.api.ProductService;
import com.productservice.serhathar.product.impl.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    @PostMapping(path = "/add")
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request) {
        ProductDto product = service.createProduct(request.toDto());
        return ResponseEntity.ok(ProductResponse.toResponse(product));
    }

    @GetMapping(path = "/get/{categoryName}")
    public ResponseEntity<List<ProductResponse>> getAllProducts(@PathVariable String categoryName) {
        List<ProductResponse> productResponseList = toResponse(service.getProductByCategory(categoryName));
        return ResponseEntity.ok(productResponseList);
    }

    @GetMapping(path = "/get-all")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> productResponseList = toResponse(service.getAllProducts());
        return ResponseEntity.ok(productResponseList);
    }

    @GetMapping(path = "/get-active")
    public ResponseEntity<List<ProductResponse>> getActiveProducts() {
        List<ProductResponse> productResponseList = toResponse(service.findProductByStatusIsTrue());
        return ResponseEntity.ok(productResponseList);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable(value = "id") String id, @Valid @RequestBody ProductRequest request) {
        ProductDto product = service.updateProduct(id, request.toDto());
        return ResponseEntity.ok(ProductResponse.toResponse(product));
    }

    @PutMapping(path = "/delete-status/{id}")
    public void delete_statusProduct(@PathVariable(value = "id") String id, ProductDto dto) {
        Product product = service.getProductById(id);
        product.setStatus(false);
        service.updateProduct(id, dto);
        //repository.save(product);
    }

    @DeleteMapping(path = "/delete/{id}")
    void delete(@PathVariable(value = "id") String id) {

        //service.deleteProduct(id);
    }

    public List<ProductResponse> toResponse(List<ProductDto> productDtoList) {
        return productDtoList.stream().map(ProductResponse::toResponse).toList();

    }
}