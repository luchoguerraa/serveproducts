package com.products.controllers;

import com.products.domain.UseCaseProducts;
import com.products.domain.dto.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/private/store/products", produces = "application/json")
public class ProductsController {

    private final UseCaseProducts useCaseProducts;

    public ProductsController(final UseCaseProducts useCaseProducts){
        this.useCaseProducts = useCaseProducts;
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> products(@RequestParam final String filter) {

        List<Product> products = useCaseProducts.products(filter);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> products() {

        List<Product> products = useCaseProducts.products();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}