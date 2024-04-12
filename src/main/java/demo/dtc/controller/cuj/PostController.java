package demo.dtc.controller.cuj;

import demo.dtc.domain.cuj.Post;
import demo.dtc.dto.cuj.reponse.PostResponse;
import demo.dtc.dto.cuj.request.PostCreateRequest;



import demo.dtc.service.cuj.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post/register")
    public void registerPost(@RequestBody PostCreateRequest request){
        postService.createPost(request);
    }

    @GetMapping("/post/find/title")
    public Post getPostByTitle(@RequestParam String title){
        return postService.getPostByTitle(title);
    }

    @GetMapping("/post/list")
    public List<PostResponse> getPost(){
        return postService.getPost();
    }
}
