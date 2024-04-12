package demo.dtc.dto.cuj.reponse;

import demo.dtc.domain.cuj.Post;

public class PostResponse {
    private String title;
    private String content;

    public PostResponse(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public PostResponse(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
