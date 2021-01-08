package com.products.tools;


import com.products.data.entities.ProductEntity;
import com.products.domain.dto.Product;

import java.util.ArrayList;
import java.util.List;

public class MockProducts {

    public static List<Product> getProducts(){

        List<Product> products = new ArrayList<>();
        products.add(Product.builder().id(1l).brand("ooy eqrceli")
                .description("rlñlw brhrkaxyz")
                .image("www.lider.cl/catalogo/images/whiteLineIcon.svg")
                .price(498724l).build());
        products.add(Product.builder().id(2l).brand("dsaasd")
                .description("zlrwax bñyrhxyz")
                .image("www.lider.cl/catalogo/images/babyIcon.svg")
                .price(130173l).build());
        products.add(Product.builder().id(3l).brand("weñxoab")
                .description("hqhoy qacirkxyz")
                .image("www.lider.cl/catalogo/images/homeIcon.svg")
                .price(171740l).build());
        products.add(Product.builder().id(4l).brand("sjlzxeo")
                .description("pnyn rlxbewnkxyz")
                .image("www.lider.cl/catalogo/images/computerIcon.svg")
                .price(890348l).build());
        products.add(Product.builder().id(5l).brand("peuoooypt")
                .description("trcwl iagxxhxyz")
                .image("www.lider.cl/catalogo/images/whiteLineIcon.svg")
                .price(814893l).build());

        return products;
    }

    public static List<Product> getProductsPalindrome(){

        List<Product> products = new ArrayList<>();
        products.add(Product.builder().id(1l).brand("ooy eqrceliaaa")
                .description("rlñlw brhrkaxyz")
                .image("www.lider.cl/catalogo/images/whiteLineIcon.svg")
                .discount(true)
                .price(498724l).build());
        products.add(Product.builder().id(2l).brand("dsaasdaaa")
                .description("zlrwax bñyrhxyz")
                .image("www.lider.cl/catalogo/images/babyIcon.svg")
                .discount(true)
                .price(130173l).build());
        products.add(Product.builder().id(3l).brand("weñxoabaaa")
                .description("hqhoy qacirkxyz")
                .discount(true)
                .image("www.lider.cl/catalogo/images/homeIcon.svg")
                .price(171740l).build());
        products.add(Product.builder().id(4l).brand("sjlzxeoaaa")
                .description("pnyn rlxbewnkxyz")
                .image("www.lider.cl/catalogo/images/computerIcon.svg")
                .discount(true)
                .price(890348l).build());
        products.add(Product.builder().id(5l).brand("peuoooyptaaa")
                .description("trcwl iagxxhxyz")
                .discount(true)
                .image("www.lider.cl/catalogo/images/whiteLineIcon.svg")
                .price(814893l).build());

        return products;
    }




    public static List<ProductEntity> getProductsEntity(){

        List<ProductEntity> products = new ArrayList<>();
        products.add(ProductEntity.builder().id(1l).brand("ooy eqrceli")
                .description("rlñlw brhrkaxyz")
                .image("www.lider.cl/catalogo/images/whiteLineIcon.svg")
                .price(498724l).build());
        products.add(ProductEntity.builder().id(2l).brand("dsaasd")
                .description("zlrwax bñyrhxyz")
                .image("www.lider.cl/catalogo/images/babyIcon.svg")
                .price(130173l).build());
        products.add(ProductEntity.builder().id(3l).brand("weñxoab")
                .description("hqhoy qacirkxyz")
                .image("www.lider.cl/catalogo/images/homeIcon.svg")
                .price(171740l).build());
        products.add(ProductEntity.builder().id(4l).brand("sjlzxeo")
                .description("pnyn rlxbewnkxyz")
                .image("www.lider.cl/catalogo/images/computerIcon.svg")
                .price(890348l).build());
        products.add(ProductEntity.builder().id(5l).brand("peuoooypt")
                .description("trcwl iagxxhxyz")
                .image("www.lider.cl/catalogo/images/whiteLineIcon.svg")
                .price(814893l).build());

        return products;
    }

    public static List<ProductEntity> getProductsEntityForService(){

        List<ProductEntity> products = new ArrayList<>();
        products.add(ProductEntity.builder().id(1l).brand("ooy eqrceli")
                .description("rlñlw brhrkaxyz")
                .image("www.lider.cl/catalogo/images/whiteLineIcon.svg")
                .price(498724l).build());
        products.add(ProductEntity.builder().id(2l).brand("dsaasd")
                .description("zlrwax bñyrhxyz")
                .image("www.lider.cl/catalogo/images/babyIcon.svg")
                .price(130173l).build());
        products.add(ProductEntity.builder().id(3l).brand("weñxoab")
                .description("hqhoy qacirkxyz")
                .image("www.lider.cl/catalogo/images/homeIcon.svg")
                .price(171740l).build());
        products.add(ProductEntity.builder().id(4l).brand("sjlzxeo")
                .description("pnyn rlxbewnkxyz")
                .image("www.lider.cl/catalogo/images/computerIcon.svg")
                .price(890348l).build());
        products.add(ProductEntity.builder().id(5l).brand("peuoooypt")
                .description("trcwl iagxxhxyz")
                .image("www.lider.cl/catalogo/images/whiteLineIcon.svg")
                .price(814893l).build());
        products.add(ProductEntity.builder().id(69l).brand("peuoooypt")
                .description("ana iagxxhxyz")
                .image("www.lider.cl/catalogo/images/whiteLineIcon.svg")
                .price(814893l).build());

        return products;
    }

    public static List<Product> getOneProductsEntityIsNotPalindrome(){

        List<Product> products = new ArrayList<>();
        products.add(Product.builder().id(123l).brand("ooy eqrceli")
                .description("rlñlw brhrkaxyz")
                .image("www.lider.cl/catalogo/images/whiteLineIcon.svg")
                .discount(false)
                .price(498724l).build());

        return products;
    }

    public static List<Product> getOneProductsEntityIsPalindrome(){

        List<Product> products = new ArrayList<>();
        products.add(Product.builder().id(181l).brand("ooy eqrceli")
                .description("rlñlw brhrka")
                .image("www.lider.cl/catalogo/images/whiteLineIcon.svg")
                .discount(true)
                .price(249362l).build());

        return products;
    }

}
