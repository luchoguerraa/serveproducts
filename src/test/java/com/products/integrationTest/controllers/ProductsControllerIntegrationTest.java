package com.products.integrationTest.controllers;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static com.products.tools.FileResource.contentOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integration")
@AutoConfigureMockMvc
public class ProductsControllerIntegrationTest {

    private static final String PRODUCTS_URI = "/api/v1/private/store/products";
    private static final String PRODUCTS_URI_FULL = "/api/v1/private/store/products/";

    @Autowired
    private MockMvc mvc;


    @Test
    public void returnListProductsWhenEndPointIsCalledAndFilterIsNotNumeric() throws Exception {

        String filter ="xyz";
        String responseExpected = readFile("products/successProducts.json");

        this.mvc.perform(get(PRODUCTS_URI)
                .param("filter", filter)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(responseExpected, true));
    }

    @Test
    public void returnListProductsWhenEndPointIsCalledAndFilterIsNumeric() throws Exception {

        String filter ="1";
        String responseExpected = readFile("products/oneProductsPalindromeIntgr.json");

        this.mvc.perform(get(PRODUCTS_URI)
                .param("filter", filter)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(responseExpected, true));
    }

    @Test
    public void returnFullListProduct() throws Exception {

        String responseExpected = readFile("products/successProducts.json");

        this.mvc.perform(get(PRODUCTS_URI_FULL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(responseExpected, true));
    }

    private String readFile(final String filename) throws IOException {
        return contentOf(filename);
    }
}
