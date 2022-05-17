package my.spring.service.genre;

import my.spring.domain.Genre;

import java.util.List;

public interface GenreService {
    Genre getGenreById(long id);

    List<Genre> getAllGenres();
    
}
