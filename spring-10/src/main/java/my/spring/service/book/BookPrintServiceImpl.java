package my.spring.service.book;

import lombok.RequiredArgsConstructor;
import my.spring.domain.Book;
import my.spring.service.InputOutputService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookPrintServiceImpl implements BookPrintService{
    private final InputOutputService io;

    public void printBook(Book book) {
        io.printString("Название книги: %s, код книги: %s, автор: %s, жанр: %s", new Object[] { book.getName(), book.getId(), book.getAuthor().getName(), book.getGenre().getName() });
    }

    public void printListBooks(List<Book> books) {
        for (Book book: books) {
            printBook(book);
        }

        if (books.stream().count() == 0)
            io.printString("Список пуст!", null);
    }
}
