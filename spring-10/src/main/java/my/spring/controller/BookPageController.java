package my.spring.controller;

import lombok.RequiredArgsConstructor;
import my.spring.service.author.AuthorService;
import my.spring.service.book.BookService;
import my.spring.service.genre.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class BookPageController {

    private final BookService bookServ;
    private final AuthorService authorServ;
    private final GenreService genreServ;

    @GetMapping("/")
    public String listPage(Model model) {
        return "list";
    }
}
