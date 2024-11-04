package dev.elshan.socialmedia.controller;

import dev.elshan.socialmedia.model.Post;
import dev.elshan.socialmedia.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService service;

    @GetMapping("/{id}")
    public Post getService(@PathVariable Long id) {
        return service.getPostById(id);
    }

    @PostMapping
    public void createPost(@RequestBody Post post){
        service.addPost(post);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post post){
        service.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        service.deletePost(id);
    }
}
