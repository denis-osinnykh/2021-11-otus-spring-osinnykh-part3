package my.spring.service.book;

import my.spring.domain.Book;

import java.util.List;

public interface BookPrintService {

    void printBook(Book book);

    void printListBooks(List<Book> books);
}
