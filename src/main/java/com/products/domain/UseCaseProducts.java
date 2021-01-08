package com.products.domain;


import com.products.data.entities.ProductEntity;
import com.products.domain.dto.Product;
import com.products.domain.filters.FilterByProducts;
import com.products.domain.mappers.ProductsMapper;
import com.products.domain.respository.ProductsRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UseCaseProducts {


    private FilterByProducts filterByProducts;
    private final ProductsRepository productListRepository;
    private final Converter<List<ProductEntity>, List<Product>> productsMapper = new ProductsMapper();
    private final double PERCENT_TO_DISCOUNT = 0.5;

    public UseCaseProducts(final ProductsRepository useCaseProductsRepository,final FilterByProducts filterByProducts) {
        this.productListRepository = useCaseProductsRepository;
        this.filterByProducts = filterByProducts;
    }

    public List<Product> products(String searchedWord) {

        List<ProductEntity> productsEntity = productListRepository.productsEntity();
        productsEntity = this.filterProductsEntity(productsEntity, searchedWord);
        List<Product> products = productsMapper.convert(productsEntity);

        if (this.isPalindrome(searchedWord)) {
            products = this.getDiscount(products);
        }

        return products;
    }

    public List<Product> products() {

        List<ProductEntity> productsEntity = productListRepository.productsEntity();
        List<Product> products = productsMapper.convert(productsEntity);
        return products;
    }

    private List<ProductEntity> filterProductsEntity(List<ProductEntity> productsEntity, String filter) {

        List<ProductEntity> productsEntityFilter;

        if (this.isNumeric(filter)) {
            int id = this.stringToInt(filter);
            productsEntityFilter = filterByProducts.filterById(productsEntity, id);

        } else {
            productsEntityFilter = filterByProducts.filterByWord(productsEntity, filter);
        }

        return productsEntityFilter;
    }

    private boolean isNumeric(String searchedWord) {

        String regex = "[0-9]*";
        return searchedWord.matches(regex);
    }

    private int stringToInt(String wordSearched) {

        return Integer.parseInt(wordSearched);
    }

    private boolean isPalindrome(String searchedWord) {

        StringBuffer reverseString = new StringBuffer("");

        for (int i = searchedWord.length() - 1; i >= 0; i--) {
            reverseString.append(searchedWord.charAt(i));
        }
        if (searchedWord.equalsIgnoreCase(reverseString.toString())) {
            return true;
        }
        return false;
    }

    private List<Product> getDiscount(List<Product> products) {

        return products.stream()
                .map(product -> Product.builder()
                        .id(product.getId())
                        .brand(product.getBrand())
                        .image(product.getImage())
                        .price(this.calculatePercent(product.getPrice(), PERCENT_TO_DISCOUNT))
                        .description(product.getDescription())
                        .discount(true)
                        .build())
                .collect(Collectors.toList());
    }

    private Long calculatePercent(Long price, double percent) {
        return (long) (price * percent);
    }

}
