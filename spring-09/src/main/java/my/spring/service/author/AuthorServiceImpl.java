package my.spring.service.author;

import lombok.RequiredArgsConstructor;
import my.spring.domain.Author;
import my.spring.repositories.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorJpa;

    @Transactional(readOnly = true)
    public Author getAuthorById(long id) {
        try {
            return authorJpa.findAuthorById(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional(readOnly = true)
    public List<Author> getAllAuthors() {
        try {
            return authorJpa.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public boolean addAuthor(String name) {
        try {
            Author newAuthor = new Author(0, name);

            authorJpa.save(newAuthor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
