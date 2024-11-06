package dev.elshan.socialmedia.service.impl;

import dev.elshan.socialmedia.dto.request.CommentCreateRequest;
import dev.elshan.socialmedia.model.Comment;
import dev.elshan.socialmedia.repository.CommentRepository;
import dev.elshan.socialmedia.service.CommentService;
import dev.elshan.socialmedia.service.PostService;
import dev.elshan.socialmedia.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;
    private final UserService userService;
    private final PostService postService;

    @Override
    public Comment getCommentById(Long commentId) {
        return repository.findById(commentId).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"No comment found with this id"));
    }

    @Override
    public void addComment(CommentCreateRequest request) {
        var comment = Comment
                .builder()
                .content(request.getContent())
                .user(userService.getUserById(request.getUserId()))
                .post(postService.getPostById(request.getPostId()))
                .build();
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

    @Override
    public void addLikeToComment(Long commentId) {
        var comment = getCommentById(commentId);
        comment.setLikes(comment.getLikes() + 1);
        repository.save(comment);
    }

    @Override
    public void removeLikeFromComment(Long commentId) {
        var comment = getCommentById(commentId);
        comment.setLikes(comment.getLikes() - 1);
        repository.save(comment);
    }
}
