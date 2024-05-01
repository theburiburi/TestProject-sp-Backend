package demo.dtc.controller;

import demo.dtc.dto.request.CommentCreateRequest;
import demo.dtc.service.CommentService;
import demo.dtc.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{postId}/comment")
    public void registerComment(@RequestBody CommentCreateRequest request, @PathVariable Long postId){
        commentService.saveComment(request, postId);
    }
}
