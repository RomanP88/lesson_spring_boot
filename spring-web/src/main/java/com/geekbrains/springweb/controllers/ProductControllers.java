package com.geekbrains.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductControllers {


    @GetMapping
    public String indexProducts(){
        return "index";
    }

}
