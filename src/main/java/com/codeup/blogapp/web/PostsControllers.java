package com.codeup.blogapp.web;

import com.codeup.blogapp.data.post.Post;
import com.codeup.blogapp.data.post.PostsRepository;
import com.codeup.blogapp.data.user.User;
import com.codeup.blogapp.data.user.UserRepository;
import com.codeup.blogapp.services.EmailService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsControllers {

    private final EmailService emailService;
    private final PostsRepository postsRepository;
    private final UserRepository userRepository;

    public PostsControllers(EmailService emailService,
                            PostsRepository postsRepository, UserRepository userRepository){
        this.emailService = emailService;
        this.postsRepository = postsRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    private List<Post> getPosts(){
        System.out.println(postsRepository.findAll());
        return postsRepository.findAll();
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id){
        return postsRepository.getById(id);
    }

    @PostMapping
    private void create(@RequestBody Post newPost, OAuth2Authentication auth){
        String email = auth.getName();
        User user = userRepository.findByEmail(email).get();
        newPost.setUser(user);
        postsRepository.save(newPost);
//        emailService.prepareAndSend(newPost, "First Email Test", "Whats Good Peeps");
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
