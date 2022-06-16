package com.geekbrains.springweb.services;

import com.geekbrains.springweb.model.Product;
import com.geekbrains.springweb.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;


    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductsAll(){
        return productRepository.getProductsAll();
    }


    public Product getById(Long id){
        return productRepository.getById(id);
    }

    public void save(Product product){
        productRepository.save(product);

    }


    public void getChange(Long productId, Integer delta){
        Product product = productRepository.getById(productId);
        product.setCost(product.getCost() + delta);
    }
}
