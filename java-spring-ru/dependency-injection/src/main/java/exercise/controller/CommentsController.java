package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("comments")
public class CommentsController {
    @Autowired
    private CommentRepository commentRepository;
    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> get() {
        return commentRepository.findAll();
    }
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment getById(@PathVariable long id) {
        return commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
    }
    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment post(@RequestBody Comment commentData) {
        commentRepository.save(commentData);
        return commentData;
    }
    @PutMapping(path = "/{id}")
    public Comment put(@PathVariable long id, @RequestBody Comment commentData) {
        var foundComment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        foundComment.setBody(commentData.getBody());
        foundComment.setPostId(commentData.getPostId());
        foundComment.setCreatedAt(commentData.getCreatedAt());
        commentRepository.save(foundComment);
        return foundComment;
    }
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id) {
        commentRepository.deleteById(id);
    }
}
// END
