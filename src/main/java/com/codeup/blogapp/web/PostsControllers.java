package com.codeup.blogapp.web;

import com.codeup.blogapp.data.post.Post;
import com.codeup.blogapp.data.post.PostsRepository;
import com.codeup.blogapp.services.EmailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsControllers {

    private final EmailService emailService;
    private final PostsRepository postsRepository;

    public PostsControllers(EmailService emailService, PostsRepository postsRepository){
        this.emailService = emailService;
        this.postsRepository = postsRepository;
    }

    @GetMapping
    private List<Post> getPosts(){
       return postsRepository.findAll();
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id){
        return postsRepository.getById(id);
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost){
        System.out.println(newPost.getId());
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
        postsRepository.save(newPost);
        emailService.prepareAndSend(newPost, "First Email Test", "Whats Good Peeps");
    }

    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post changedPost){
        System.out.println("Updating post with id: " + id);
        System.out.println(changedPost.getTitle());
        System.out.println(changedPost.getContent());
        postsRepository.save(changedPost);
    }

    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id){
        System.out.println("Deleted Post with id: " + id);
        postsRepository.deleteById(id);
    }
}
