package com.products.data;


import com.products.data.entities.ProductEntity;
import com.products.data.repository.RepositoryDB;
import com.products.exceptions.GlobalException;
import com.products.tools.MockProducts;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UseCaseProductsRepositoryImplTest {

    @Mock
    private RepositoryDB repositoryDB;

    @InjectMocks
    UseCaseProductsRepositoryImpl useCaseProductsRepositoryImpl;

    @Test
    public void callFindAll(){

        when(repositoryDB.findAll()).thenReturn(MockProducts.getProductsEntity());
        List<ProductEntity> productsEntity = useCaseProductsRepositoryImpl.productsEntity();
        Assert.assertNotNull(productsEntity);

    }

    @Test(expected = GlobalException.class)
    public void callFindAllAndReturnGlobalException(){

        when(repositoryDB.findAll()).thenReturn(null);
        useCaseProductsRepositoryImpl.productsEntity();

    }

}
