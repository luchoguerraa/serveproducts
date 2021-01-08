package com.products.data;

import com.products.data.entities.ProductEntity;
import com.products.data.repository.RepositoryDB;
import com.products.domain.respository.ProductsRepository;
import com.products.exceptions.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UseCaseProductsRepositoryImpl implements ProductsRepository {


    @Autowired
    private RepositoryDB repositoryDB;

    @Override
    public List<ProductEntity> productsEntity() {

        List<ProductEntity> productsEntity = repositoryDB.findAll();
        if(Optional.ofNullable(productsEntity).isPresent()){
            return productsEntity;
        }
        throw new GlobalException("Error gateway", HttpStatus.BAD_GATEWAY);
    }
}
