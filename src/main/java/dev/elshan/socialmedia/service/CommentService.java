package dev.elshan.socialmedia.service;

import dev.elshan.socialmedia.model.Comment;

public interface CommentService {

    Comment getCommentById(Long commentId);
    void addComment(Comment comment);
    void updateComment(Long commentId,Comment comment);
    void deleteComment(Long commentId);
}
