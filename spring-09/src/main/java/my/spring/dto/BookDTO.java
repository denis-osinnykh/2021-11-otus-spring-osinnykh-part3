package my.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import my.spring.domain.Author;
import my.spring.domain.Book;
import my.spring.domain.Genre;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class BookDTO {
    private long id;

    @NotBlank(message = "Название книги не должно быть пустым")
    private String name;

    private Author author;

    private Genre genre;

    private List<Author> allAuthors;

    private List<Genre> allGenres;

    public BookDTO(long id, String name, Author author, Genre genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public Book toDomainObject() { return new Book(id, name, author, genre); }

    public static BookDTO fromDomainObject(Book book) {
        BookDTO dto = new BookDTO(book.getId(), book.getName(), book.getAuthor(), book.getGenre());
        //dto.allAuthors =
        return dto;
    }
}
