package com.productservice.serhathar.product.api;

import com.productservice.serhathar.product.impl.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto dto);
    List<ProductDto> getAllProducts();
    List<ProductDto> findProductByStatusIsTrue();
    void deleteProduct(String id);
    ProductDto updateProduct(String id , ProductDto product);
    List<ProductDto> getProductByCategory(String categoryName);
    Product getProductById(String id);
    List<ProductDto> findAllByStatusAndCategoryStatus(Boolean productStatus, Boolean categoryStatus);

    static List<Product> toProductList(List<ProductDto> dtos){
        List<Product> products = new ArrayList<>();
        for (ProductDto dto : dtos) {
            Product product = new Product();
            products.add(product);
        }
        return products;
    }

    static List<ProductDto> toProductDtoList(List<Product> products) {
        List<ProductDto> dtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto dto = new ProductDto();
            dtos.add(dto);
        }
        return dtos;
    }

}