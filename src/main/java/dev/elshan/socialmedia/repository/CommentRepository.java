package dev.elshan.socialmedia.repository;

import dev.elshan.socialmedia.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
