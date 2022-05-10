package my.spring.service.author;

import lombok.RequiredArgsConstructor;
import my.spring.domain.Author;
import my.spring.service.InputOutputService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorPrintServiceImpl implements AuthorPrintService {
    private final InputOutputService io;

    public void printAuthor(Author author) {
        io.printString("Имя автора: %s, код автора: %s", new Object[] { author.getName(), author.getId() });
    }

    public void printListAuthors(List<Author> authors) {
        for (Author author: authors) {
            printAuthor(author);
        }
    }
}
