package dev.elshan.socialmedia.service;

import dev.elshan.socialmedia.dto.request.PostCreateRequest;
import dev.elshan.socialmedia.dto.request.PostUpdateRequest;
import dev.elshan.socialmedia.dto.response.PostResponse;
import dev.elshan.socialmedia.model.Post;

public interface PostService {

    Post getPostById(Long postId);
    void addPost(PostCreateRequest request);
    void updatePost(Long postId, PostUpdateRequest request);
    void deletePost(Long postId);
    void addLikeToPost(Long postId);
    void removeLikeFromPost(Long postId);
}
