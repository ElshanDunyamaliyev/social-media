package dev.elshan.socialmedia.service;

import dev.elshan.socialmedia.dto.request.CommentCreateRequest;
import dev.elshan.socialmedia.model.Comment;

public interface CommentService {

    Comment getCommentById(Long commentId);
    void addComment(CommentCreateRequest request);
    void updateComment(Long commentId,Comment comment);
    void deleteComment(Long commentId);
    void addLikeToComment(Long commentId);
    void removeLikeFromComment(Long commentId);
}
