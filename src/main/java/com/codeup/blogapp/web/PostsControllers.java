package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsControllers {

    List<Category> categories = new ArrayList<>(){{
        add(new Category(1l, "Spring Boot"));
        add(new Category(2l, "Why JS Views Make my head hurt"));
    }};

    @GetMapping
    private List<Post> getPosts(){
        User blogger = new User(5l, "SuitCaseBlogger", "random@eamil.com",
                "test1234", null);

        return new ArrayList<>(){{

            add(new Post(1l, "a new post", "this is a brilliant post", blogger,categories));
            add (new Post(2l, "a newer post", "Even better content than the previous" +
                "post", blogger, categories));
            add(new Post(3l, "a new post", "I prefer this post", blogger, categories));
        }};
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id){
        User postOwner = new User(4l, "lilly", "random@email.com", "test123",
                null);

        if(id == 1){
            return new Post(1l, "a new post", "this is a brilliant post", postOwner,
                    categories);
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
