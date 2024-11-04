package dev.elshan.socialmedia.service.impl;

import dev.elshan.socialmedia.model.Post;
import dev.elshan.socialmedia.repository.PostRepository;
import dev.elshan.socialmedia.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository repository;
    @Override
    public Post getPostById(Long postId) {
        return null;
    }

    @Override
    public void addPost() {

    }

    @Override
    public void updatePost() {

    }

    @Override
    public void deletePost() {

    }
}
