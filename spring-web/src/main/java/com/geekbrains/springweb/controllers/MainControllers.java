package com.geekbrains.springweb.controllers;

import com.geekbrains.springweb.model.Product;
import com.geekbrains.springweb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MainControllers {

   private ProductService productService;

    @Autowired
    public MainControllers(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping("/products")
    public String productsGetAll(Model model){
        model.addAttribute("productAll", productService.getProductsAll());
        return "prod_all";
    }



    @GetMapping("/products/{id}")
    public String productsById(Model model, @PathVariable Long id){
        Product product = productService.getById(id);
        model.addAttribute("pro", product);
        return "product_info";
    }


    @GetMapping("/create")
    public String createProducts(){
        return "create_pro";
    }


    @PostMapping("/create")
    public String createProducts(@RequestParam Long id, @RequestParam String title, @RequestParam int cost){
        productService.save(new Product(id, title,cost));
        return "redirect:/products";
    }


    @GetMapping("/productsAll")
    @ResponseBody
    public List<Product> getProductsAll(){
        return productService.getProductsAll();
    }

    @GetMapping("/productsAll/change_score")
    @ResponseBody
    public void changeScore(@RequestParam Long productId, @RequestParam Integer delta) {

        productService.getChange(productId,delta);
    }

}
