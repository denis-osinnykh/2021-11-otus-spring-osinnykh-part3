package my.spring.controller;

import lombok.RequiredArgsConstructor;
import my.spring.domain.Genre;
import my.spring.service.genre.GenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GenreController {

    private final GenreService genreServ;

    @GetMapping("/genres")
    public List<Genre> getAllGenres() {
        return genreServ.getAllGenres();
    }
}
