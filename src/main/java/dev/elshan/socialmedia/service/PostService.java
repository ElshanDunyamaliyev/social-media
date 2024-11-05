package dev.elshan.socialmedia.service;

import dev.elshan.socialmedia.dto.PostUpdateRequest;
import dev.elshan.socialmedia.model.Post;

public interface PostService {

    Post getPostById(Long postId);
    void addPost(Post post);
    void updatePost(Long postId, PostUpdateRequest request);
    void deletePost(Long postId);
}
