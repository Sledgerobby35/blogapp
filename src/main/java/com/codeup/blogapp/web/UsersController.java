package com.codeup.blogapp.web;


import com.codeup.blogapp.data.user.User;
import com.codeup.blogapp.data.user.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    private final UserRepository userRepository;

    public UsersController (UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @GetMapping
    private List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    private User findById(@PathVariable Long id){
        return userRepository.getById(id);
    }
    @PostMapping
    private void postUser(@RequestBody User user){
        System.out.println(user.getEmail());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        userRepository.save(user);
    }

    @PutMapping("{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword){
        System.out.println("Your previous password was: " + oldPassword);
        System.out.println("Your password has now been changed" + newPassword);
    }

    @GetMapping("/findByUsername")
    private User findByUsername(@RequestParam String username){
        return userRepository.findByUsername(username);
    }

    @GetMapping("/findByEmail")
    private User findByEmail(@RequestParam String email){
        return userRepository.findByEmail(email).get();
    }
}
