package my.spring.controller;

import lombok.RequiredArgsConstructor;
import my.spring.domain.Author;
import my.spring.domain.Comment;
import my.spring.domain.Genre;
import my.spring.dto.BookDTO;
import my.spring.service.author.AuthorService;
import my.spring.service.book.BookService;
import my.spring.service.comment.CommentService;
import my.spring.service.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService bookServ;

    @GetMapping("/books")
    public List<BookDTO> getAllBooks() {
        return bookServ.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public BookDTO getBook(@PathVariable("id") long id) {
        return bookServ.getBookById(id);
    }

    @GetMapping("/books/{id}/comments")
    public List<Comment> getAllCommentsByBookId(@PathVariable("id") long id) {
        return bookServ.getBookById(id).getAllBookComments();
    }

    @PatchMapping("/books")
    public boolean saveBook(@RequestBody BookDTO bookDTO) {
        return bookServ.saveBook(bookDTO);
    }

    @PostMapping("/books")
    public boolean addBook(@RequestBody BookDTO bookDTO) {
        return bookServ.addBook(bookDTO);
    }

    @DeleteMapping("/books/{id}")
    public boolean deleteBook(@PathVariable("id") long id) {
        return bookServ.deleteBookById(id);
    }
}
