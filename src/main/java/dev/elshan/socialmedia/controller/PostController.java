package dev.elshan.socialmedia.controller;

import dev.elshan.socialmedia.dto.request.PostCreateRequest;
import dev.elshan.socialmedia.dto.request.PostUpdateRequest;
import dev.elshan.socialmedia.dto.response.PostResponse;
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
    public Post getPost(@PathVariable Long id) {
        return service.getPostById(id);
    }

    @PostMapping
    public void createPost(@RequestBody PostCreateRequest request){
        service.addPost(request);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostUpdateRequest request){
        service.updatePost(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        service.deletePost(id);
    }

    @PutMapping("/like/add/{id}")
    public void likePost(@PathVariable Long id){
        service.addLikeToPost(id);
    }

    @PutMapping("/like/delete/{id}")
    public void dislikePost(@PathVariable Long id){
        service.removeLikeFromPost(id);
    }
}
