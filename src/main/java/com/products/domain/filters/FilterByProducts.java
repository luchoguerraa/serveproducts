 package com.products.domain.filters;

import com.products.data.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FilterByProducts {
    private static final int MINIMUMS_SIZE_OF_WORD = 3;

    public  List<ProductEntity> filterById(List<ProductEntity> productEntities, Integer id) {

        List<ProductEntity> productEntitiesToReturn = productEntities.stream()
                .filter(productEntity -> productEntity.getId().toString().equals(id.toString())).
                        collect(Collectors.toList());

        return productEntitiesToReturn;
    }

    public  List<ProductEntity> filterByWord(List<ProductEntity> productEntities, String searchedWord) {

        List<ProductEntity> productEntitiesToReturn = productEntities.stream()
                .filter(productEntity -> (isContained(productEntity.getBrand(), searchedWord) || isContained(productEntity.getDescription(), searchedWord))).
                        collect(Collectors.toList());

        return productEntitiesToReturn;
    }

    private  boolean isContained(String word, String searchedWord) {

        if (Optional.ofNullable(searchedWord).isPresent() && searchedWord.length() >= MINIMUMS_SIZE_OF_WORD) {
            return (word.contains(searchedWord.substring(0, 3)) || word.contains(searchedWord));
        } else {
            return false;
        }

    }

}
