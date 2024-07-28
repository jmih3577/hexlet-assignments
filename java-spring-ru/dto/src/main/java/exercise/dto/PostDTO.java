package exercise.dto;

import java.util.List;

import lombok.Data;

// BEGIN
@Data
public class PostDTO {
    private long id;

    private String title;

    private String body;
    private List<CommentDTO> comments;
}
// END
