package com.products.integrationTest.mocks;

import com.products.data.entities.ProductEntity;
import com.products.domain.respository.ProductsRepository;
import com.products.tools.MockProducts;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Profile("integration")
@Repository
public class UseCaseProductsRepositoryMock implements ProductsRepository {
        @Override
        public List<ProductEntity> productsEntity() {
            return MockProducts.getProductsEntity();
    }
}
