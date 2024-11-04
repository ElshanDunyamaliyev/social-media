package dev.elshan.socialmedia.controller;

import dev.elshan.socialmedia.model.Comment;
import dev.elshan.socialmedia.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService service;

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id){
        return service.getCommentById(id);
    }

    @PostMapping
    public void createComment(@RequestBody Comment comment){
        service.addComment(comment);
    }
}
