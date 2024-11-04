package dev.elshan.socialmedia.service;

import dev.elshan.socialmedia.model.Post;

public interface PostService {

    Post getPostById(Long postId);
    void addPost();
    void updatePost();
    void deletePost();
}
