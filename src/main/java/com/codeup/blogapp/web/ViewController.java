package com.codeup.blogapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping({"/", "/about", "/posts", "/login", "/home", "/register"}
    )
    public String showView(){
        return "forward:/index.html";
    }
}
