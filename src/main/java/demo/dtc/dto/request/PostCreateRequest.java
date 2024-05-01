package demo.dtc.dto.request;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostCreateRequest {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
