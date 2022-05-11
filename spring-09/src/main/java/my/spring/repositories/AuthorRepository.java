package my.spring.repositories;

import my.spring.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

   Author findAuthorById(long id);
}


