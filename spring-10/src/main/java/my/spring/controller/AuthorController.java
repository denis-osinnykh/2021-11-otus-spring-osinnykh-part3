package my.spring.controller;

import lombok.RequiredArgsConstructor;
import my.spring.domain.Author;
import my.spring.service.author.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AuthorController {

    private final AuthorService authorServ;

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorServ.getAllAuthors();
    }
}
