package dev.elshan.socialmedia.service.impl;

import dev.elshan.socialmedia.model.Post;
import dev.elshan.socialmedia.repository.PostRepository;
import dev.elshan.socialmedia.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository repository;

    @Override
    public Post getPostById(Long postId) {
        return repository.findById(postId).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"No post found with this id"));
    }

    @Override
    public void addPost(Post post) {
        repository.save(post);
    }

    @Override
    public void updatePost(Long postId, Post post) {
        var foundedPost = getPostById(postId);
        foundedPost.setContent(post.getContent());
        repository.save(foundedPost);
    }

    @Override
    public void deletePost(Long postId) {
        repository.deleteById(postId);
    }
}
