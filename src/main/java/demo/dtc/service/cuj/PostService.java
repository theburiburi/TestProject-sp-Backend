package demo.dtc.service.cuj;

import demo.dtc.domain.cuj.Post;

import demo.dtc.dto.cuj.reponse.PostResponse;
import demo.dtc.dto.cuj.request.PostCreateRequest;

import demo.dtc.repository.cuj.PostRepository;
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
    public Post getPostByTitle(String title){
        Post post = postRepository.findByTitle(title)
                .orElseThrow(IllegalArgumentException::new);
        return post;
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPost(){
        return postRepository.findAll().stream()
                .map(myobj -> new PostResponse(myobj)).collect(Collectors.toList());
        //new PostResponse(post)
    }
}
