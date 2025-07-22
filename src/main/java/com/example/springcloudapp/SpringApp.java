package com.example.springcloudapp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SpringApp{

    @RequestMapping("/hello")
    public String sayHello(){

        return "hello";
    }

    @RequestMapping("/hello/{name}")
    public String sayHelloWithName(@PathVariable("name")
                                   String personName){

        return "hello "+personName;

    }





}


