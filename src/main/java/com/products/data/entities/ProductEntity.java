package com.products.data.entities;

import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Document(collection = "products")
public class ProductEntity {

    @Id
    ObjectId _id;
    private Long id;
    private String brand;
    private String description;
    private String image;
    private Long price;
}
