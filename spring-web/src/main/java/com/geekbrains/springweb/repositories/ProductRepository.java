package com.geekbrains.springweb.repositories;

import com.geekbrains.springweb.model.Product;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    List<Product> products;


    @PostConstruct
    public void init(){

        this.products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Milk", 40),
                new Product(2L, "Eggs", 40),
                new Product(3L, "Water", 40),
                new Product(4L, "Fish", 40),
                new Product(5L, "Cheese", 40)
        ));
    }



    public List<Product> getProductsAll(){
        return Collections.unmodifiableList(products);
    }


    public Product getById(Long id){
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(()-> new RuntimeException("Нет такого продукта"));

    }

    public void save(Product product){
        products.add(product);
    }

}
