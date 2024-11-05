package dev.elshan.socialmedia.service;

import dev.elshan.socialmedia.dto.CommentCreateRequest;
import dev.elshan.socialmedia.model.Comment;

public interface CommentService {

    Comment getCommentById(Long commentId);
    void addComment(CommentCreateRequest request);
    void updateComment(Long commentId,Comment comment);
    void deleteComment(Long commentId);
}
