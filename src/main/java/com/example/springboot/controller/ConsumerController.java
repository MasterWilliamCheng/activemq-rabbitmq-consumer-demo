package com.example.springboot.controller;

import com.example.api.ProviderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class ConsumerController {
    @Resource
    private ProviderService providerService;

    @RequestMapping("/{name}")
    public String pickOne(@PathVariable(value = "name") String name){
        String str = providerService.check(name);
        return str;
    }

    @RequestMapping("/hello")
    public String helloworld(){
        return "this is consumer hello";
    }

}
