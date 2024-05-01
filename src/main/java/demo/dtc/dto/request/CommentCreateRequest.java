package demo.dtc.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class CommentCreateRequest {
    private String commentContent;

    @JsonCreator
    public CommentCreateRequest(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentContent() {
        return commentContent;
    }
}
