package my.spring.service;

import my.spring.domain.Book;
import my.spring.dto.BookDTO;
import my.spring.service.author.AuthorService;
import my.spring.service.comment.CommentService;
import my.spring.service.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MappingService {

    private final AuthorService authorServ;
    private final GenreService genreServ;
    private final CommentService commentServ;

    @Autowired
    public MappingService(AuthorService authorServ, GenreService genreServ, CommentService commentServ) {
        this.authorServ = authorServ;
        this.genreServ = genreServ;
        this.commentServ = commentServ;
    }

    public Book bookDTOToBook(BookDTO dto) {
        return new Book(dto.getId(), dto.getName(), dto.getAuthor(), dto.getGenre());
    }

    public BookDTO bookToBookDTO(Book book) {
        BookDTO dto = new BookDTO(book.getId(), book.getName(), book.getAuthor(), book.getGenre());
        return dto;
    }

    public BookDTO createNewBookDTO() {
        BookDTO dto = new BookDTO();
        return dto;
    }
}
