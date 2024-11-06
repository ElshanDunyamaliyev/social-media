package dev.elshan.socialmedia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties({"posts", "comments"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false,name = "user_name")
    private String username;

    @Column(nullable = false, name = "email",unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Column(name = "about")
    private String about;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;
}