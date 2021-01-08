package com.products.domian.mapper;

import com.products.data.entities.ProductEntity;
import com.products.domain.dto.Product;
import com.products.domain.mappers.ProductsMapper;
import com.products.tools.MockProducts;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProductsMapperTest {

    ProductsMapper productsMapper;

    @Before
    public void setup() {

        productsMapper = new ProductsMapper();
    }

    @Test
    public void returnProductsList() {

        List<ProductEntity> productsEntity = MockProducts.getProductsEntity();

        List<Product> products = productsMapper.convert(productsEntity);

        Assert.assertEquals(products.size(), productsEntity.size());

        for (int i = 0; i < products.size(); i++) {
            Assert.assertEquals(products.get(i).getId(), productsEntity.get(i).getId());
        }

    }
}
