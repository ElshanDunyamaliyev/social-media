package dev.elshan.socialmedia.service.impl;

import dev.elshan.socialmedia.model.Comment;
import dev.elshan.socialmedia.repository.CommentRepository;
import dev.elshan.socialmedia.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;

    @Override
    public Comment getCommentById(Long commentId) {
        return null;
    }

    @Override
    public void addComment() {

    }

    @Override
    public void updateComment() {

    }

    @Override
    public void deleteComment() {

    }
}
