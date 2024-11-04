package dev.elshan.socialmedia.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<Like> likes;
}
