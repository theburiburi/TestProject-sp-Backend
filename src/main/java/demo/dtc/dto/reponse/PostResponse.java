package demo.dtc.dto.reponse;

import demo.dtc.domain.Post;
import lombok.Getter;

@Getter
public class PostResponse {
    private String title;
    private String content;

    public PostResponse(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
    }

}
