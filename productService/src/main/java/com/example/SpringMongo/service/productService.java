package com.example.SpringMongo.service;

import com.example.SpringMongo.DTO.productRequest;
import com.example.SpringMongo.DTO.productResponse;
import com.example.SpringMongo.Repository.productRepo;
import com.example.SpringMongo.models.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class productService {

    @Autowired
    private productRepo productrepo ;

    public productResponse createProduct(productRequest productrequest) {
        product product = new product(
                productrequest.id(),productrequest.name(),
        productrequest.description(),productrequest.price()
                );
        productrepo.save(product);
        productResponse pr = new productResponse(productrequest.id(), productrequest.name(),
                productrequest.description(),productrequest.price());
        return pr;
    }

    public List<productResponse> getAllProducts() {
        return productrepo.findAll()
                .stream()
                .map(product -> new productResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice()))
                .collect(Collectors.toList());
    }
}
