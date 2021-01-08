package com.products.domian;


import com.products.domain.UseCaseProducts;
import com.products.domain.dto.Product;
import com.products.domain.filters.FilterByProducts;
import com.products.domain.respository.ProductsRepository;
import com.products.tools.MockProducts;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UseCaseProductsTest {

    ProductsRepository useCaseProductsRepository;
    FilterByProducts filterByProducts;
    UseCaseProducts useCaseProducts;

    @Before
    public void setup() {

        filterByProducts = new FilterByProducts();
        useCaseProductsRepository = mock(ProductsRepository.class);
        when(useCaseProductsRepository.productsEntity()).thenReturn(MockProducts.getProductsEntityForService());
        useCaseProducts = new UseCaseProducts(useCaseProductsRepository, filterByProducts);
    }

    @Test
    public void whenProductsMethodIsCalledAndFilterIsPalindromeAndNumericReturnOneProductWithDiscount() {

        String filter = "1";
        List<Product> response = useCaseProducts.products(filter);
        Assert.assertNotNull(response);
        Assert.assertEquals(1l, response.size());
        Assert.assertTrue(response.get(0).isDiscount());

    }

    @Test
    public void whenProductsMethodIsCalledAndFilterIsNotPalindromeAndNumericReturnOneProductWithOutDiscount() {

        String filter = "69";
        List<Product> response = useCaseProducts.products(filter);
        Assert.assertNotNull(response);
        Assert.assertEquals(1l, response.size());
        Assert.assertFalse(response.get(0).isDiscount());

    }

    @Test
    public void whenProductsMethodIsCalledAndFilterIsNotNumericAndNotPalindromeReturnOneProductWithOutDiscount() {

        String filter = "zlr";
        List<Product> response = useCaseProducts.products(filter);
        Assert.assertNotNull(response);
        Assert.assertEquals(1l, response.size());
        Assert.assertFalse(response.get(0).isDiscount());

    }

    @Test
    public void whenProductsMethodIsCalledAndFilterIsNotNumericAndPalindromeReturnOneProductWithDiscount() {

        String filter = "ana";
        List<Product> response = useCaseProducts.products(filter);
        Assert.assertNotNull(response);
        Assert.assertEquals(1l, response.size());
        Assert.assertTrue(response.get(0).isDiscount());

    }

    @Test
    public void returnFullListProductWhenCallProductMethodWithParameter() {

        List<Product> response = useCaseProducts.products();
        Assert.assertNotNull(response);
        Assert.assertEquals(6l, response.size());

    }

}
