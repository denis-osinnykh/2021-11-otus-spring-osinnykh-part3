package my.spring.controller;

import lombok.RequiredArgsConstructor;
import my.spring.domain.Comment;
import my.spring.dto.BookDTO;
import my.spring.service.book.BookService;
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
    public void deleteBook(@PathVariable("id") long id) {
        bookServ.deleteBookById(id);
    }
}
