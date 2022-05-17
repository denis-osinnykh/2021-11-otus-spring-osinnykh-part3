package my.spring.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import my.spring.controller.BookController;
import my.spring.domain.Author;
import my.spring.domain.Book;
import my.spring.domain.Comment;
import my.spring.domain.Genre;
import my.spring.dto.BookDTO;
import my.spring.service.book.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
@DisplayName("Rest-контролер BookController должен")
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private BookService service;

    @Test
    @DisplayName("возвращать корректный список книг")
    void shouldReturnCorrectBooksList() throws Exception {
        Author author = new Author(1, "Author");
        Genre genre = new Genre(1, "Genre");

        List<BookDTO> dtos = List.of(new BookDTO(1, "Test book 1", author, genre), new BookDTO(2, "Test book 2", author, genre));
        given(service.getAllBooks()).willReturn(dtos);

        mvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(dtos)));
    }

    @Test
    @DisplayName("возвращать нужную книгу по коду")
    void shouldReturnCorrectBookById() throws Exception {
        Author author = new Author(1, "Author");
        Genre genre = new Genre(1, "Genre");

        BookDTO dto = new BookDTO(1, "Test book 1", author, genre);
        given(service.getBookById(1)).willReturn(dto);

        mvc.perform(get("/books/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(dto)));
    }

    @Test
    @DisplayName("возвращать нужные комментарии по коду книги")
    void shouldReturnCorrectBookCommentsByBookId() throws Exception {
        Author author = new Author(1, "Author");
        Genre genre = new Genre(1, "Genre");
        Book book = new Book("Test book 1", author, genre);
        List<Comment> comments = List.of(new Comment(1, "Test comment 1", book), new Comment(1, "Test comment 2", book));

        BookDTO dto = new BookDTO(1, "Test book 1", author, genre, comments);
        given(service.getBookById(1)).willReturn(dto);

        mvc.perform(get("/books/1/comments"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(comments)));
    }

    @Test
    @DisplayName("успешно добавлять книгу")
    void shouldCorrectAddNewBook() throws Exception {
        Author author = new Author(1, "Author");
        Genre genre = new Genre(1, "Genre");
        BookDTO dto = new BookDTO(1, "Test book 1", author, genre);

        given(service.addBook(dto)).willReturn(true);

        mvc.perform(post("/books").contentType(APPLICATION_JSON)
                    .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("успешно сохранять книгу")
    void shouldCorrectSaveBook() throws Exception {
        Author author = new Author(1, "Author");
        Genre genre = new Genre(1, "Genre");
        BookDTO dto = new BookDTO(1, "Test book 1", author, genre);

        given(service.saveBook(dto)).willReturn(true);

        mvc.perform(patch("/books").contentType(APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("успешно удалять книгу")
    void shouldCorrectDeleteBookById() throws Exception {
        mvc.perform(delete("/books/1"))
                .andExpect(status().isOk());
    }
}
