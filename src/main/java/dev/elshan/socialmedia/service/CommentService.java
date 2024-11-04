package dev.elshan.socialmedia.service;

import dev.elshan.socialmedia.model.Comment;

public interface CommentService {

    Comment getCommentById(Long commentId);
    void addComment();
    void updateComment();
    void deleteComment();
}
