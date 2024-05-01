package demo.dtc.dto.reponse;

import demo.dtc.domain.Comment;
import demo.dtc.domain.Post;
import lombok.Getter;

import java.util.List;

@Getter
public class PostWithCommentResponse {
    private String title;
    private String content;
    private List<Comment> comment;

    public PostWithCommentResponse(String title, String content, List<Comment> comment) {
        this.title = title;
        this.content = content;
        this.comment = comment;
    }
    public PostWithCommentResponse(Post post){
        this.title = post.getTitle();
        this.content = post.getContent();
        this.comment = post.getComment();
    }

}
