package dev.elshan.socialmedia.repository;

import dev.elshan.socialmedia.model.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    @EntityGraph(attributePaths = {"comments"})
    Optional<Post> findById(Long id);
}
