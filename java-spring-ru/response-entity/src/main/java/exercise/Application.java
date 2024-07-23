package exercise;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/post")
    public ResponseEntity<List<Post>> get(@RequestParam(defaultValue = "10") Integer limit) {
        var retPosts = posts.stream().limit(limit).toList();
        return ResponseEntity.ok().header("X-Total-Count", String.valueOf(posts.size())).body(retPosts);
    }
    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getById(@PathVariable String id) {
        return ResponseEntity.of(posts.stream().filter(p -> p.getId().equals(id)).findFirst());

    }
    @PostMapping("/post")
    public ResponseEntity<Post> post(@RequestBody Post post) {
        posts.add(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }
    @PutMapping("/post/{id}")
    public ResponseEntity<Post> put(@PathVariable String id, @RequestBody Post postData) {
        Optional<Post> findPost = posts.stream().filter(post -> post.getId().equals(id)).findFirst();
        if(findPost.isPresent()) {
            Post foundPost = findPost.get();
            foundPost.setBody(postData.getBody());
            foundPost.setId(postData.getId());
            foundPost.setTitle(postData.getTitle());
            return ResponseEntity.ok(postData);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(postData);
    }
    // END

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
}
