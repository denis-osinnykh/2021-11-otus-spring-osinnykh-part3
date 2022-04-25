package my.spring.controller;

import my.spring.dto.BookDTO;
import my.spring.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private BookService bookServ;

    @Autowired
    public BookController(BookService bookServ) {
        this.bookServ = bookServ;
    }

    @GetMapping("/")
    public String listPage(Model model) {
        model.addAttribute("books", bookServ.getAllBooks());
        return "list";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") long id, Model model) {
        model.addAttribute("bookDTO", bookServ.getBookById(id));
        return "edit";
    }

    @GetMapping("/view")
    public String viewPage(@RequestParam("id") long id, Model model) {
        model.addAttribute("bookDTO", bookServ.getBookById(id));
        return "view";
    }

    @PostMapping("/edit")
    public String editBook(@ModelAttribute("book") BookDTO bookDTO,
                           BindingResult bindingResult, Model model) {
        bookServ.saveBook(bookDTO);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("id") long id) {
        bookServ.deleteBookById(id);
        return "redirect:/";
    }
}
