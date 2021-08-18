package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsControllers {

    @GetMapping
    private List<Post> getPosts(){
        return new ArrayList<>(){{
            User blogger = new User(5l, "SuitCaseBlogger", "random@eamil.com",
                    "test1234", null);
            add(new Post(1l, "a new post", "this is a brilliant post", blogger));
            add (new Post(2l, "a newer post", "Even better content than the previous" +
                "post", blogger));
            add(new Post(3l, "a new post", "I prefer this post", blogger));
        }};
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id){
        if(id == 1){
            User postOwner = new User(4l, "lilly", "random@email.com", "test123",
                    null);
            return new Post(1l, "a new post", "this is a brilliant post", postOwner);
        } else {
            return null;
        }
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost){

        System.out.println(newPost.getId());
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
    }

    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post changedPost){
        System.out.println(changedPost.getId());
        System.out.println(changedPost.getTitle());
        System.out.println(changedPost.getContent());
    }

    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id){
        System.out.println("Deleted Post with id: " + id);
    }
}
