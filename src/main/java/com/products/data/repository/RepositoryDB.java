package com.products.data.repository;

import com.products.data.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDB extends MongoRepository<ProductEntity,Long> {
}
