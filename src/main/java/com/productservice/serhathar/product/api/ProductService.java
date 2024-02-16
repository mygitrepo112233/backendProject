package com.productservice.serhathar.product.api;

import com.productservice.serhathar.product.impl.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto dto);
    List<ProductDto> getAllProducts();
    List<ProductDto> findProductByStatusIsTrue();
    void deleteProduct(String id);
    ProductDto updateProduct(String id , ProductDto product);
    List<ProductDto> getProductByCategory(String categoryName);
}