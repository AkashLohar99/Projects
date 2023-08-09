package com.numetry.in.service;

import com.numetry.in.entity.Product;

import java.util.List;

public interface ProductService {
    List <Product> searchProducts(String query);

    Product createProduct(Product product);

    //
}
