package demo.dtc.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String commentContent;


    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

    public Comment(String commentContent, Post post) {
        this.commentContent = commentContent;
        this.post = post;
    }
    public String getCommentContent() {
        return commentContent;
    }
}
