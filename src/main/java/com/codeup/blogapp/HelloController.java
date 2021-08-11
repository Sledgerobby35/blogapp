package com.codeup.blogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello, from Spring!";
    }

    @GetMapping("/person")
    @ResponseBody
    public Person getPerson(){
        return new Person("Robert");
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("/home")
    public String welcome(){
        return "home.html";
    }
}
