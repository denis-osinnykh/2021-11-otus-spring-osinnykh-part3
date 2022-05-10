package my.spring.service.genre;

import lombok.RequiredArgsConstructor;
import my.spring.domain.Genre;
import my.spring.service.InputOutputService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GenrePrintSeriveImpl implements GenrePrintService {
    private final InputOutputService io;

    public void printGenre(Genre genre) {
        io.printString("Название жанра: %s, код жанра: %s", new Object[] { genre.getName(), genre.getId() });
    }

    public void printListGenres(List<Genre> genres) {
        for (Genre genre: genres) {
            printGenre(genre);
        }
    }
}
