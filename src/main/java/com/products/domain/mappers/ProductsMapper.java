package com.products.domain.mappers;


import com.products.data.entities.ProductEntity;
import com.products.domain.dto.Product;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class ProductsMapper implements Converter<List<ProductEntity>,List<Product>> {

    @Override
    public List<Product> convert(List<ProductEntity> productsEntity) {

        List<Product> products = new ArrayList<>();

        productsEntity.forEach(productEntity -> {
            products.add(Product.builder()
                    .id(productEntity.getId())
                    .price(productEntity.getPrice())
                    .image(productEntity.getImage())
                    .description(productEntity.getDescription())
                    .brand(productEntity.getBrand())
                    .build());
        });


        return products;
    }
}
