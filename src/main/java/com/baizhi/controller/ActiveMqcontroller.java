package com.baizhi.controller;

import com.baizhi.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/active")
public class ActiveMqcontroller {
    @Autowired
    Product product;

    @RequestMapping("/test")
    public void activesend(String msg) {
        product.sendMessage(msg);
    }
}
