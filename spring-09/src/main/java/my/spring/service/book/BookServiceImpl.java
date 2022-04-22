package my.spring.service.book;

import lombok.RequiredArgsConstructor;
import my.spring.domain.Author;
import my.spring.domain.Book;
import my.spring.domain.Genre;
import my.spring.repositories.AuthorRepository;
import my.spring.repositories.BookRepository;
import my.spring.repositories.GenreRepository;
import my.spring.service.InputOutputService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final InputOutputService io;
    private final BookRepository bookJpa;
    private final AuthorRepository authorJpa;
    private final GenreRepository genreJpa;

    @Transactional(readOnly = true)
    public long getBooksCount() {
        return bookJpa.count();
    }

    @Transactional(readOnly = true)
    public Book getBookById(long id) {
        try {
            return bookJpa.findBookById(id);
        } catch (Exception e) {
            io.printString("Ошибка выполнения запроса! Книга не найдена!\n " + e.getMessage(), null);
            return null;
        }
    }

    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        try {
            return bookJpa.findAll();
        } catch (Exception e) {
            io.printString("Ошибка выполнения запроса! Книги не найдены!\n " + e.getMessage(), null);
            return null;
        }
    }

    @Transactional
    public boolean addBook(String bookName, long authorId, long genreId) {
        try {
            Author author = authorJpa.findAuthorById(authorId);
            Genre genre = genreJpa.findGenreById(genreId);
            Book newBook =  new Book(0, bookName, author, genre);

            bookJpa.save(newBook);
            return true;
        } catch (Exception e) {
            io.printString("Ошибка выполнения запроса! Книга не добавлена!\n " + e.getMessage(), null);
            return false;
        }
    }

    @Transactional
    public boolean updateBookNameById(String bookName, long id) {
        try {
            bookJpa.updateNameById(bookName, id);
            return true;
        } catch (Exception e) {
            io.printString("Ошибка выполнения запроса! Книга не обновлена!\n " + e.getMessage(), null);
            return false;
        }
    }

    @Transactional
    public boolean updateBookAuthorById(long authorId, long id) {
        try {
            Author author = authorJpa.findAuthorById(authorId);
            bookJpa.updateAuthorById(author, id);
            return true;
        } catch (Exception e) {
            io.printString("Ошибка выполнения запроса! Книга не обновлена!\n " + e.getMessage(), null);
            return false;
        }
    }

    @Transactional
    public boolean updateBookGenreById(long genreId, long id) {
        try {
            Genre genre = genreJpa.findGenreById(genreId);
            bookJpa.updateGenreById(genre, id);
            return true;
        } catch (Exception e) {
            io.printString("Ошибка выполнения запроса! Книга не обновлена!\n " + e.getMessage(), null);
            return false;
        }
    }

    @Transactional
    public boolean deleteBookById(long id) {
        try {
            bookJpa.deleteById(id);
            return true;
        } catch (Exception e) {
            io.printString("Ошибка выполнения запроса! Книга не удалена!\n " + e.getMessage(), null);
            return false;
        }
    }
}
