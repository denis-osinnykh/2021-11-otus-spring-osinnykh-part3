package my.spring.controller;

import lombok.RequiredArgsConstructor;
import my.spring.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BookController {

    private BookRepository repository;

    @GetMapping("/")
    public String listPage(Model model) {
        model.addAttribute("books", repository.findAll());
        return "list";
    }
}
