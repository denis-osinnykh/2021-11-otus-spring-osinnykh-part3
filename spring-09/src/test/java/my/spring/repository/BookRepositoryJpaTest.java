package my.spring.repository;

import my.spring.domain.Author;
import my.spring.domain.Book;
import my.spring.domain.Genre;
import my.spring.repositories.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@DisplayName("Jpa для работы с книгами должен")
public class BookRepositoryJpaTest {

    private static final long EXPECTED_BOOKS_COUNT = 1;
    private static final long EXPECTED_BOOK_ID = 1;
    private static final String EXPECTED_BOOK_NAME = "Test book";
    private static final long EXPECTED_BOOK_AUTHOR_ID = 1;
    private static final String EXPECTED_BOOK_AUTHOR_NAME = "Test author";
    private static final long EXPECTED_BOOK_GENRE_ID = 1;
    private static final String EXPECTED_BOOK_GENRE_NAME = "Test genre";
    private static final int EXPECTED_NUMBER_OF_BOOKS = 1;

    private static final long NEW_BOOK_ID = 2;
    private static final String NEW_BOOK_NAME = "Test book 2";
    private static final long NEW_BOOK_AUTHOR_ID = 2;
    private static final String NEW_BOOK_AUTHOR_NAME = "Test author 2";
    private static final long NEW_BOOK_GENRE_ID = 2;
    private static final String NEW_BOOK_GENRE_NAME = "Test genre 2";

    @Autowired
    private BookRepository jpa;

    @Autowired
    private TestEntityManager em;

    @Test
    @DisplayName("добавлять книгу корректно")
    void shouldAddBook() {
        Author expectedAuthor = new Author(EXPECTED_BOOK_AUTHOR_ID, EXPECTED_BOOK_AUTHOR_NAME);
        Genre expectedGenre = new Genre(EXPECTED_BOOK_GENRE_ID, EXPECTED_BOOK_GENRE_NAME);
        Book expectedNewBook = new Book(NEW_BOOK_ID, NEW_BOOK_NAME, expectedAuthor, expectedGenre);
        jpa.save(expectedNewBook);
        assertThat(jpa.findBookById(NEW_BOOK_ID)).isNotNull()
                .hasFieldOrPropertyWithValue("name", NEW_BOOK_NAME)
                .hasFieldOrPropertyWithValue("author", expectedAuthor)
                .hasFieldOrPropertyWithValue("genre", expectedGenre)
        ;
    }

    @Test
    @DisplayName("обновлять книгу")
    void shouldUpdateBook() {
        jpa.updateNameById(NEW_BOOK_NAME, EXPECTED_BOOK_ID);
        assertEquals(NEW_BOOK_NAME, jpa.findBookById(EXPECTED_BOOK_ID).getName());
    }

    @Test
    @DisplayName("обновлять автора у книги")
    void shouldUpdateAuthorBook() {
        Author newAuthor = new Author(NEW_BOOK_AUTHOR_ID, NEW_BOOK_AUTHOR_NAME);
        jpa.updateAuthorById(newAuthor, EXPECTED_BOOK_ID);
        assertEquals(newAuthor, jpa.findBookById(EXPECTED_BOOK_ID).getAuthor());
    }

    @Test
    @DisplayName("обновлять жанр у книги")
    void shouldUpdateGenreBook() {
        Genre newGenre = new Genre(NEW_BOOK_GENRE_ID, NEW_BOOK_GENRE_NAME);
        jpa.updateGenreById(newGenre, EXPECTED_BOOK_ID);
        assertEquals(newGenre, jpa.findBookById(EXPECTED_BOOK_ID).getGenre());
    }
}
