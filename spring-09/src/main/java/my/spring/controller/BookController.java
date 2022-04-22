package my.spring.controller;

import my.spring.dto.BookDTO;
import my.spring.repositories.AuthorRepository;
import my.spring.repositories.BookRepository;
import my.spring.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private BookRepository bookRep;
    private AuthorRepository authorRep;
    private GenreRepository genreRep;

    @Autowired
    public BookController(BookRepository bookRep, AuthorRepository authorRep, GenreRepository genreRep) {
        this.bookRep = bookRep;
        this.authorRep = authorRep;
        this.genreRep = genreRep;
    }


    @GetMapping("/")
    public String listPage(Model model) {
        model.addAttribute("books", bookRep.findAll());
        return "list";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") long id, Model model) {
        BookDTO dto = BookDTO.fromDomainObject(bookRep.getById(id));
        dto.setAllAuthors(authorRep.findAll());
        dto.setAllGenres(genreRep.findAll());
        model.addAttribute("bookDTO", dto);
        return "edit";
    }

    @PostMapping("/edit")
    public String editBook(@ModelAttribute("book") BookDTO bookDTO,
                           BindingResult bindingResult, Model model) {
        bookRep.save(bookDTO.toDomainObject());
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("id") long id) {
        bookRep.deleteById(id);
        return "redirect:/";
    }
}
