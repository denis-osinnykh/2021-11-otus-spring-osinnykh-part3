package my.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import my.spring.domain.Author;
import my.spring.domain.Comment;
import my.spring.domain.Genre;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
public class BookDTO {
    private long id;

    @NotBlank(message = "Название книги не должно быть пустым")
    private String name;

    private Author author;

    private Genre genre;

    private List<Comment> allBookComments;

    public BookDTO(long id, String name, Author author, Genre genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
    }
}
