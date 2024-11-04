package dev.elshan.socialmedia.service;

import dev.elshan.socialmedia.model.Like;

public interface LikeService {

    void addLike(Like like);
    void deleteLike(Long likeId);
}
