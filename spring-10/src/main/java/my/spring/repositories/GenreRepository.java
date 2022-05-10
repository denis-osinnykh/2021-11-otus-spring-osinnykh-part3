package my.spring.repositories;

import my.spring.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    Genre findGenreById(long id);
}