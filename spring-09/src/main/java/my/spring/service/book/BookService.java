package my.spring.service.book;

import my.spring.domain.Book;
import my.spring.dto.BookDTO;
import org.springframework.lang.Nullable;

import java.util.List;

public interface BookService {

    long getBooksCount();

    BookDTO getBookById(long id);

    List<BookDTO> getAllBooks();

    boolean addBook(String bookName, @Nullable long authorId, @Nullable long genreId);

    boolean saveBook(BookDTO bookDTO);

    boolean updateBookNameById(String bookName, long id);

    boolean updateBookAuthorById(long author_id, long id);

    boolean updateBookGenreById(long genre_id, long id);

    boolean deleteBookById(long id);
}
