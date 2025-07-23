package com.example.SpringMongo.controllers;


import com.example.SpringMongo.DTO.productRequest;
import com.example.SpringMongo.DTO.productResponse;
import com.example.SpringMongo.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class productController {

    @Autowired
    private productService productservice;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public productResponse createProduct(@RequestBody productRequest productrequest){
       return   productservice.createProduct(productrequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<productResponse> getAllProducts(){
         return productservice.getAllProducts();
    }

}
