package dev.elshan.socialmedia.repository;

import dev.elshan.socialmedia.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Long> {
}
