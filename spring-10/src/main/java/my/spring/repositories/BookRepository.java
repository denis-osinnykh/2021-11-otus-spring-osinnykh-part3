package my.spring.repositories;

import my.spring.domain.Author;
import my.spring.domain.Book;
import my.spring.domain.Genre;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @EntityGraph(value = "books-entity-graph")
    Book findBookById(long id);

    @EntityGraph(value = "books-entity-graph")
    List<Book> findAll();

    @Modifying
    @Query("update Book b set b.name = :name where b.id = :id")
    void updateNameById(String name, long id);

    @Modifying
    @Query("update Book b set b.author = :author where b.id = :id")
    void updateAuthorById(Author author, long id);

    @Modifying
    @Query("update Book b set b.genre = :genre where b.id = :id")
    void updateGenreById(Genre genre, long id);
}
