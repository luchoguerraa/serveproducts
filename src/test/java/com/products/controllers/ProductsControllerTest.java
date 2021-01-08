package com.products.controllers;

import com.products.domain.UseCaseProducts;
import com.products.domain.dto.Product;
import com.products.tools.MockProducts;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.util.List;

import static com.products.tools.FileResource.contentOf;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ProductsControllerTest {

    private static final String PRODUCTS_URI = "/api/v1/private/store/products";

    @Mock
    private UseCaseProducts useCaseProducts;

    @InjectMocks
    private ProductsController productsController;

    private MockMvc mvc;

    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.standaloneSetup(this.productsController).build();
    }

    @Test
    public void returnListProductsWhenEndPointIsCalledAndFilterParamIsNotNumericAndIsNotPalindrome() throws Exception {

        String filter ="xyz";
        List<Product> productsMocks = MockProducts.getProducts();
        String responseExpected = readFile("products/successProducts.json");
        when(useCaseProducts.products(filter)).thenReturn(productsMocks);

        this.mvc.perform(get(PRODUCTS_URI)
                .param("filter", filter)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseExpected, true));
    }

    @Test
    public void returnListProductsWhenEndPointIsCalledAndFilterParamIsNotNumericAndIsPalindrome() throws Exception {

        String filter ="aaa";
        List<Product> productsMocks = MockProducts.getProductsPalindrome();
        String responseExpected = readFile("products/successProductsPalindrome.json");
        when(useCaseProducts.products(filter)).thenReturn(productsMocks);

        this.mvc.perform(get(PRODUCTS_URI)
                .param("filter", filter)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseExpected, true));
    }

    @Test
    public void returnListProductsWhenEndPointIsCalledAndFilterParamIsNumericAndIsNotPalindrome() throws Exception {

        String filter ="123";
        List<Product> productsMocks = MockProducts.getOneProductsEntityIsNotPalindrome();
        String responseExpected = readFile("products/oneProducts.json");
        when(useCaseProducts.products(filter)).thenReturn(productsMocks);

        this.mvc.perform(get(PRODUCTS_URI)
                .param("filter", filter)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseExpected, true));
    }

    @Test
    public void returnListProductsWhenEndPointIsCalledAndFilterParamIsNumericAndIsPalindrome() throws Exception {

        String filter ="181";
        List<Product> productsMocks = MockProducts.getOneProductsEntityIsPalindrome();
        String responseExpected = readFile("products/oneProductsPalindrome.json");
        when(useCaseProducts.products(filter)).thenReturn(productsMocks);

        this.mvc.perform(get(PRODUCTS_URI)
                .param("filter", filter)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseExpected, true));
    }

    @Test
    public void returnListProductsWhenEndPointIsCalledAndFilterParamIsEmpty() throws Exception {

        String filter ="";
        List<Product> productsMocks = MockProducts.getProducts();
        String responseExpected = readFile("products/successProducts.json");
        when(useCaseProducts.products(filter)).thenReturn(productsMocks);

        this.mvc.perform(get(PRODUCTS_URI)
                .param("filter", filter)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseExpected, true));
    }

    @Test
    public void returnListProductsWhenEndPointIsCalledAndFilterParamIsNull() throws Exception {

        this.mvc.perform(get(PRODUCTS_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());

    }


    private String readFile(final String filename) throws IOException {
        return contentOf(filename);
    }

}
