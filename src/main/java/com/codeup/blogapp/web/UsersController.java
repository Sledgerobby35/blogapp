package com.codeup.blogapp.web;


import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    @GetMapping
    private List<User> getUsers() {
        return new ArrayList<>() {{
            add(new User(1, "Robdge", "Robby@email.com", "password", null));
            add(new User(2, "willie", "william@email.com", "uniquePassword", null));
            add(new User(3, "wizard King", "Yuno@email.com", "best", null));
        }};
    }

    @GetMapping("{id}")
    private void findById(@PathVariable Long id){
        System.out.println(id);
    }
    @PostMapping
    private void postUser(@RequestBody User user){
        System.out.println(user.getEmail());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }

    @PutMapping("{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword){
        System.out.println("Your previous password was: " + oldPassword);
        System.out.println("Your password has now been changed");
    }

    @GetMapping("/findByUsername")
    private User findByUsername(@RequestParam String username){
        return getUsers().stream()
                .filter(users -> username.equals(users.getUsername()))
                .findFirst().orElse(null);
    }

    @GetMapping("/findByEmail")
    private User findByEmail(@RequestParam String email){
        return getUsers().stream()
                .filter(users -> email.equals(users.getEmail()))
                .findFirst().orElse(null);
    }
}
