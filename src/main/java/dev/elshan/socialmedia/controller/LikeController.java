package dev.elshan.socialmedia.controller;

import dev.elshan.socialmedia.model.Like;
import dev.elshan.socialmedia.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/likes")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService service;

    @PostMapping
    public void createLike(Like like){
        service.addLike(like);
    }

    @DeleteMapping("/{id}")
    public void deleteLike(@PathVariable Long id){
        service.deleteLike(id);
    }
}
