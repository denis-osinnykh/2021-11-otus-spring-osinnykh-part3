package my.spring.service;

import my.spring.domain.Author;
import my.spring.domain.Book;
import my.spring.domain.Genre;
import my.spring.repositories.AuthorRepository;
import my.spring.repositories.BookRepository;
import my.spring.repositories.GenreRepository;
import my.spring.service.book.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest
@DisplayName("Класс BookServiceImpl должен")
public class BookServiceImplTest {

    private static final long EXPECTED_BOOK_ID = 1;
    private static final String EXPECTED_BOOK_NAME = "Test book 1";
    private static final long EXPECTED_BOOK_AUTHOR_ID = 1;
    private static final String EXPECTED_BOOK_AUTHOR_NAME = "Test author";
    private static final long EXPECTED_BOOK_GENRE_ID = 1;
    private static final String EXPECTED_BOOK_GENRE_NAME = "Test genre";

    private static final long NOT_EXPECTED_BOOK_ID = -1;
    private static final long DELETED_BOOK_ID = 2;
    private static final long NOT_EXPECTED_BOOK_AUTHOR_ID = 10;
    private static final String NOT_EXPECTED_BOOK_AUTHOR_NAME = "Test author 10";
    private static final long NOT_EXPECTED_BOOK_GENRE_ID = 10;
    private static final String NOT_EXPECTED_BOOK_GENRE_NAME = "Test genre 10";

    private static final long NEW_BOOK_ID = 10;
    private static final String NEW_BOOK_NAME = "Test book 10";
    private static final long NEW_BOOK_AUTHOR_ID = 2;
    private static final String NEW_BOOK_AUTHOR_NAME = "Test author 2";
    private static final long NEW_BOOK_GENRE_ID = 2;
    private static final String NEW_BOOK_GENRE_NAME = "Test genre 2";

    @MockBean
    private BookRepository bookJpa;
    @MockBean
    private AuthorRepository authorJpa;
    @MockBean
    private GenreRepository genreJpa;
    @Autowired
    private BookService bs;

    @Test
    @DisplayName("возвращать количество книг")
    void shouldGetBooksCount() {
        assertThat(bs.getBooksCount()).isNotNull();
    }

    @Test
    @DisplayName("возвращать книгу по коду")
    void shouldGetBookById() {
        Author expectedAuthor = new Author(EXPECTED_BOOK_AUTHOR_ID, EXPECTED_BOOK_AUTHOR_NAME);
        Genre expectedGenre = new Genre(EXPECTED_BOOK_GENRE_ID, EXPECTED_BOOK_GENRE_NAME);
        given(this.bookJpa.findBookById(EXPECTED_BOOK_ID))
                .willReturn(new Book(EXPECTED_BOOK_ID, EXPECTED_BOOK_NAME, expectedAuthor, expectedGenre));
        assertThat(bs.getBookById(EXPECTED_BOOK_ID)).isNotNull();
    }

    @Test
    @DisplayName("возвращать null, если книга по коду не найдена")
    void shouldGetEmptyBookById() {
        given(this.bookJpa.findBookById(NOT_EXPECTED_BOOK_ID))
                .willReturn(null);
        assertEquals(null, bs.getBookById(NOT_EXPECTED_BOOK_ID));
    }

    @Test
    @DisplayName("возвращать true при добавлении, если книга была добавлена")
    void shouldReturnTrueAfterAdding() {
        Author newAuthor = new Author(EXPECTED_BOOK_AUTHOR_ID, EXPECTED_BOOK_AUTHOR_NAME);
        Genre newGenre = new Genre(EXPECTED_BOOK_GENRE_ID, EXPECTED_BOOK_GENRE_NAME);
        Book newBook = new Book(NEW_BOOK_ID, NEW_BOOK_NAME, newAuthor, newGenre);

        given(this.authorJpa.findAuthorById(EXPECTED_BOOK_AUTHOR_ID))
                .willReturn(newAuthor);
        given(this.genreJpa.findGenreById(EXPECTED_BOOK_GENRE_ID))
                .willReturn(newGenre);

        boolean result = bs.addBook(NEW_BOOK_NAME, EXPECTED_BOOK_AUTHOR_ID, EXPECTED_BOOK_GENRE_ID);
        assertEquals(true, result);
    }

    @Test
    @DisplayName("возвращать true при обновлении, если книга была обновлена")
    void shouldReturnTrueAfterUpdateing() {
        doNothing().when(this.bookJpa).updateNameById(NEW_BOOK_NAME, EXPECTED_BOOK_ID);
        boolean result = bs.updateBookNameById(NEW_BOOK_NAME, EXPECTED_BOOK_ID);
        assertEquals(true, result);
    }

    @Test
    @DisplayName("возвращать false при обновлении, если книга не была обновлена")
    void shouldReturnFalseAfterUpdateing() {
        doThrow(new EmptyResultDataAccessException(1)).when(this.bookJpa).updateNameById(NEW_BOOK_NAME, NOT_EXPECTED_BOOK_ID);
        boolean result = bs.updateBookNameById(NEW_BOOK_NAME, NOT_EXPECTED_BOOK_ID);
        assertEquals(false, result);
    }

    @Test
    @DisplayName("возвращать false при добавлении, если книга добавлена не была")
    void shouldReturnFalseAfterAdding() {
        Author notExpectedAuthor = new Author(NOT_EXPECTED_BOOK_AUTHOR_ID, NOT_EXPECTED_BOOK_AUTHOR_NAME);
        Genre notExpectedGenre = new Genre(NOT_EXPECTED_BOOK_GENRE_ID, NOT_EXPECTED_BOOK_GENRE_NAME);

        doThrow(new EmptyResultDataAccessException(1)).when(this.authorJpa).findAuthorById(NOT_EXPECTED_BOOK_AUTHOR_ID);

        boolean result = bs.addBook(EXPECTED_BOOK_NAME, NOT_EXPECTED_BOOK_AUTHOR_ID, NOT_EXPECTED_BOOK_GENRE_ID);
        assertEquals(false, result);
    }

    @Test
    @DisplayName("возвращать список книг")
    void shouldGetNullAllBooks() {
        given(this.bookJpa.findAll())
                .willReturn(new ArrayList<>());
        assertThat(bs.getAllBooks()).isNotNull();
    }

    @Test
    @DisplayName("возвращать true, если книга удалена")
    void shouldReturnTrueAfterDeleting() {
        doNothing().when(this.bookJpa).deleteById(DELETED_BOOK_ID);
        boolean result = bs.deleteBookById(DELETED_BOOK_ID);
        assertEquals(true, result);
    }

    @Test
    @DisplayName("возвращать false, если книга не была удалена")
    void shouldReturnFalseAfterDeleting() {
        doThrow(new EmptyResultDataAccessException(1)).when(this.bookJpa).deleteById(NOT_EXPECTED_BOOK_ID);
        boolean result = bs.deleteBookById(NOT_EXPECTED_BOOK_ID);
        assertEquals(false, result);
    }
}
