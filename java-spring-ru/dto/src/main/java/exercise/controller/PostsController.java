package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    CommentRepository cr;

    @Autowired
    PostRepository pr;

    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDTO> get() {
        return pr.findAll().stream().map(this::postConvert).toList();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO getById(@PathVariable Long id) {
        return pr.findById(id).map(this::postConvert).orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
    }

    public PostDTO postConvert(Post post) {
        var pDTO = new PostDTO();
        pDTO.setId(post.getId());
        pDTO.setBody(post.getBody());
        pDTO.setTitle(post.getTitle());
        pDTO.setComments(cr.findByPostId(post.getId()).stream().map(this::commentConvert).toList());
        return pDTO;
    }

    public CommentDTO commentConvert(Comment comment) {
        var cDTO = new CommentDTO();
        cDTO.setId(comment.getId());
        cDTO.setBody(comment.getBody());

        return cDTO;
    }
}
// END
