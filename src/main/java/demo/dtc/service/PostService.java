package demo.dtc.service;

import demo.dtc.domain.Comment;
import demo.dtc.domain.Post;
import demo.dtc.dto.reponse.PostResponse;
import demo.dtc.dto.reponse.PostWithCommentResponse;
import demo.dtc.dto.request.PostCreateRequest;
import demo.dtc.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public void createPost(PostCreateRequest request){
        postRepository.save(new Post(request.getTitle(), request.getContent()));
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostByTitle(String title){
        return postRepository.findByTitle(title).stream()
                .map(POST -> new PostResponse(POST)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPost(){
        return postRepository.findAll().stream()
                .map(myobj -> new PostResponse(myobj)).collect(Collectors.toList());
        //new PostResponse(post)
    }

    @Transactional(readOnly = true)
    public PostWithCommentResponse getPostWithComment(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(IllegalArgumentException::new);

        return new PostWithCommentResponse(post);
    }
}
