package com.productservice.serhathar.category.web;

import com.productservice.serhathar.category.api.CategoryDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CategoryResponse {

    private String id;
    private String name;
    private String description;
    private Boolean status;
    private Date creaDate;

    public static CategoryResponse toResponse(CategoryDto dto){
        return CategoryResponse.builder()
                .id(dto.getId())
                .status(dto.getStatus())
                .name(dto.getName())
                .description(dto.getDescription())
                .creaDate(dto.getCreaDate())
                .build();
    }
}