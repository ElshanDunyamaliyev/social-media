package dev.elshan.socialmedia.dto.response;

import dev.elshan.socialmedia.model.Comment;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostResponse {

    private String content;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;
    private long likes = 0L;
}
