package my.spring.service;

import lombok.RequiredArgsConstructor;
import my.spring.domain.Book;
import my.spring.dto.BookDTO;
import my.spring.service.author.AuthorService;
import my.spring.service.comment.CommentService;
import my.spring.service.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MappingService {

    private AuthorService authorServ;
    private GenreService genreServ;
    private CommentService commentServ;

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
        dto.setAllAuthors(authorServ.getAllAuthors());
        dto.setAllGenres(genreServ.getAllGenres());
        dto.setAllBookComments(commentServ.getAllCommentsByBookId(book.getId()));
        return dto;
    }

    public BookDTO createNewBookDTO() {
        BookDTO dto = new BookDTO();
        dto.setAllAuthors(authorServ.getAllAuthors());
        dto.setAllGenres(genreServ.getAllGenres());
        return dto;
    }
}
