package com.codeup.blogapp.web;


import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    @GetMapping
    private List<User> getUsers() {
        return new ArrayList<>() {{
            add(new User(1, "Robdge", "Robby", "password"));
            add(new User(2, "willie", "william", "uniquePassword"));
            add(new User(3, "wizard King", "Yuno", "best"));
        }};
    }

    @PostMapping
    private void postUser(@RequestBody User user){
        System.out.println(user.getEmail());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }
}
