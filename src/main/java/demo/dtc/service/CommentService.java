package demo.dtc.service;

import demo.dtc.domain.Comment;
import demo.dtc.domain.Post;
import demo.dtc.dto.request.CommentCreateRequest;
import demo.dtc.repository.CommentRepository;
import demo.dtc.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    public void saveComment(CommentCreateRequest request, Long postId){
        Post post = postRepository.findById(postId).orElseThrow(IllegalArgumentException::new);
        post.saveComment(request.getCommentContent());
    }
}
