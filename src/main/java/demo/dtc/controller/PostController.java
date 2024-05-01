package demo.dtc.controller;

import demo.dtc.domain.Comment;
import demo.dtc.dto.reponse.PostResponse;
import demo.dtc.dto.reponse.PostWithCommentResponse;
import demo.dtc.dto.request.PostCreateRequest;
import demo.dtc.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post/register")
    public void registerPost(@RequestBody PostCreateRequest request){
        postService.createPost(request);
    }
    @GetMapping("/post/find/title")
    public List<PostResponse> getPostByTitle(@RequestParam String title){
        return postService.getPostByTitle(title);
    }

    @GetMapping("/post/list")
    public List<PostResponse> getPost(){
        return postService.getPost();
    }

    @GetMapping("/post/{postId}")
    public PostWithCommentResponse getPostWithComment(@PathVariable Long postId){
        return postService.getPostWithComment(postId);
    }
}
