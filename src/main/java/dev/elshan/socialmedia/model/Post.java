package dev.elshan.socialmedia.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false,name = "content")
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    private long likes = 0L;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
