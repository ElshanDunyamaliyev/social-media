package dev.elshan.socialmedia.service.impl;

import dev.elshan.socialmedia.dto.request.PostCreateRequest;
import dev.elshan.socialmedia.dto.request.PostUpdateRequest;
import dev.elshan.socialmedia.dto.response.PostResponse;
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
    private final UserServiceImpl userService;

    @Override
    public Post getPostById(Long postId) {
        return repository.findById(postId).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"No post found with this id"));
    }

    @Override
    public void addPost(PostCreateRequest request) {
        var post = Post.builder().content(request.getContent()).build();
        repository.save(post);
    }

    @Override
    public void updatePost(Long postId, PostUpdateRequest request) {
        var foundedPost = getPostById(postId);
        foundedPost.setContent(request.getContent() != null ? request.getContent() : foundedPost.getContent());
        foundedPost.setUser(userService.getUserById(request.getUserId()));
        repository.save(foundedPost);
    }

    @Override
    public void deletePost(Long postId) {
        repository.deleteById(postId);
    }

    @Override
    public void addLikeToPost(Long postId) {
        var post = getPostById(postId);
        post.setLikes(post.getLikes() + 1);
        repository.save(post);
    }

    @Override
    public void removeLikeFromPost(Long postId) {
        var post = getPostById(postId);
        post.setLikes(post.getLikes() - 1);
        repository.save(post);
    }
}
