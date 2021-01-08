package com.products.domian.filters;

import com.products.data.entities.ProductEntity;
import com.products.domain.filters.FilterByProducts;
import com.products.tools.MockProducts;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FilterByProductsTest {

    private FilterByProducts filterByProducts;

    @Before
    public void setup(){

        filterByProducts = new FilterByProducts();
    }

    @Test
    public void filterByIdReturnOnlyOneResult(){

        Integer filter = 1;
        List<ProductEntity> productsEntity = MockProducts.getProductsEntity();

        List<ProductEntity> products = filterByProducts.filterById(productsEntity,filter);

        Assert.assertEquals(products.size(),1);

    }

    @Test
    public void filterByWordReturnListFiltered(){

        String filter = "xyz";
        List<ProductEntity> productsEntity = MockProducts.getProductsEntity();

        List<ProductEntity> products = filterByProducts.filterByWord(productsEntity,filter);

        Assert.assertEquals(products.size(),5);

    }

    @Test
    public void filterByEmptyWordReturnAnyResult(){

        String filter = "";
        List<ProductEntity> productsEntity = MockProducts.getProductsEntity();

        List<ProductEntity> products = filterByProducts.filterByWord(productsEntity,filter);

        Assert.assertEquals(products.size(),0);

    }

    @Test
    public void filterNullReturnAnyResult(){

        String filter = null;
        List<ProductEntity> productsEntity = MockProducts.getProductsEntity();

        List<ProductEntity> products = filterByProducts.filterByWord(productsEntity,filter);

        Assert.assertEquals(products.size(),0);

    }
}
