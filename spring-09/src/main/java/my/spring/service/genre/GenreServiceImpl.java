package my.spring.service.genre;

import lombok.RequiredArgsConstructor;
import my.spring.domain.Genre;
import my.spring.repositories.GenreRepository;
import my.spring.service.InputOutputService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreJpa;
    private final InputOutputService io;

    @Transactional(readOnly = true)
    public Genre getGenreById(long id) {
        try {
            return genreJpa.findGenreById(id);
        } catch (Exception e) {
            io.printString("Ошибка выполнения запроса! Жанр не найден!\n " + e.getMessage(), null);
            return null;
        }
    }

    @Transactional(readOnly = true)
    public List<Genre> getAllGenres() {
        try {
            return genreJpa.findAll();
        } catch (Exception e) {
            io.printString("Ошибка выполнения запроса! Жанр не найден!\n " + e.getMessage(), null);
            return null;
        }
    }
}
