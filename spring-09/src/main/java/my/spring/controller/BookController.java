package my.spring.controller;

import my.spring.dto.BookDTO;
import my.spring.service.author.AuthorService;
import my.spring.service.book.BookService;
import my.spring.service.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private BookService bookServ;
    private AuthorService authorServ;
    private GenreService genreServ;

    @Autowired
    public BookController(BookService bookServ, AuthorService authorServ, GenreService genreServ) {
        this.bookServ = bookServ;
        this.authorServ = authorServ;
        this.genreServ = genreServ;
    }

    @GetMapping("/")
    public String listPage(Model model) {
        model.addAttribute("books", bookServ.getAllBooks());
        return "list";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") long id, Model model) {
        model.addAttribute("bookDTO", bookServ.getBookById(id));
        model.addAttribute("allAuthors", authorServ.getAllAuthors());
        model.addAttribute("allGenres", genreServ.getAllGenres());
        return "edit";
    }

    @PostMapping("/edit")
    public String editBook(@ModelAttribute("book") BookDTO bookDTO) {
        bookServ.saveBook(bookDTO);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("bookDTO", bookServ.getNewBook());
        model.addAttribute("allAuthors", authorServ.getAllAuthors());
        model.addAttribute("allGenres", genreServ.getAllGenres());
        return "add";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") BookDTO bookDTO) {
        bookServ.addBook(bookDTO);
        return "redirect:/";
    }

    @GetMapping("/view")
    public String viewPage(@RequestParam("id") long id, Model model) {
        model.addAttribute("bookDTO", bookServ.getBookById(id));
        return "view";
    }

    @PostMapping("/delete")
    public String deleteBook(@RequestParam("id") long id) {
        bookServ.deleteBookById(id);
        return "redirect:/";
    }
}
