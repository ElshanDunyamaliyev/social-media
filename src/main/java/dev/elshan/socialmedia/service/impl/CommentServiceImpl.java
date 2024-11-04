package dev.elshan.socialmedia.service.impl;

import dev.elshan.socialmedia.model.Comment;
import dev.elshan.socialmedia.repository.CommentRepository;
import dev.elshan.socialmedia.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;

    @Override
    public Comment getCommentById(Long commentId) {
        return repository.findById(commentId).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"No comment found with this id"));
    }

    @Override
    public void addComment(Comment comment) {
        repository.save(comment);
    }

    @Override
    public void updateComment(Long commentId, Comment comment) {
        var foundedComment = getCommentById(commentId);
        foundedComment.setContent(comment.getContent());
        repository.save(foundedComment);
    }

    @Override
    public void deleteComment(Long commentId) {
        repository.deleteById(commentId);
    }
}
