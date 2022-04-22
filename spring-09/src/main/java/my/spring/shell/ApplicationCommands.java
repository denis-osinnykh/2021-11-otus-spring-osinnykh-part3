package my.spring.shell;

import lombok.RequiredArgsConstructor;
import my.spring.domain.Author;
import my.spring.domain.Book;
import my.spring.domain.Comment;
import my.spring.domain.Genre;
import my.spring.service.*;
import my.spring.service.author.AuthorPrintService;
import my.spring.service.author.AuthorService;
import my.spring.service.book.BookPrintService;
import my.spring.service.book.BookService;
import my.spring.service.comment.CommentPrintService;
import my.spring.service.comment.CommentService;
import my.spring.service.genre.GenrePrintService;
import my.spring.service.genre.GenreService;
import java.util.List;

@RequiredArgsConstructor
public class ApplicationCommands {
    private final BookService bs;
    private final AuthorService as;
    private final GenreService gs;
    private final CommentService cs;
    private final InputOutputService io;
    private final BookPrintService bps;
    private final AuthorPrintService aps;
    private final GenrePrintService gps;
    private final CommentPrintService cps;
/*
    @ShellMethod(value = "Get count of books", key = {"gcb", "get count"})
    public void getBooksCount() {
        long count = bs.getBooksCount();
        io.printString("Количество книг: %s", new Object[] { count });
    }

    @ShellMethod(value = "Get book by id", key = {"gbi", "get book"})
    public void getBookById(@ShellOption String id) {
        Book book = bs.getBookById(id);
        if (book != null)
            bps.printBook(book);
    }

    @ShellMethod(value = "Get all books", key = {"gab", "get all books"})
    public void getAllBooks() {
        List<Book> books = bs.getAllBooks();
        if (books != null)
            bps.printListBooks(books);
    }

    @ShellMethod(value = "Add the book", key = {"ab", "add book"})
    public void addBooks(@ShellOption String bookName, @ShellOption String authorId, @ShellOption String genreId) {
        boolean result = bs.addBook(bookName, authorId, genreId);
        if (result)
            io.printString("Книга добавлена!", null);
    }

    @ShellMethod(value = "Update the book name by id", key = {"ubi", "update book name"})
    public void updateBookNameById(@ShellOption String id, @ShellOption String bookName) {
        boolean result = bs.updateBookNameById(bookName, id);
        if (result)
            io.printString("Книга обновлена!", null);
    }

    @ShellMethod(value = "Update the book author by id", key = {"uba", "update book author"})
    public void updateBookAuthorById(@ShellOption String id, @ShellOption String authorId) {
        boolean result = bs.updateBookAuthorById(authorId, id);
        if (result)
            io.printString("Автор у книги обновлен!", null);
    }

    @ShellMethod(value = "Update the book genre by id", key = {"ubg", "update book genre"})
    public void updateBookGenreById(@ShellOption String id, @ShellOption String genreId) {
        boolean result = bs.updateBookGenreById(genreId, id);
        if (result)
            io.printString("Жанр у книги обновлен!", null);
    }
    
    @ShellMethod(value = "Delete the book", key = {"db", "delete book"})
    public void deleteBookById(@ShellOption String id) {
        boolean result = bs.deleteBookById(id);
        if (result)
            io.printString("Книга удалена!", null);
    }

    @ShellMethod(value = "Get all authors", key = {"gaa", "get all authors"})
    public void getAllAuthors() {
        List<Author> authors = as.getAllAuthors();
        if (authors != null)
            aps.printListAuthors(authors);
    }

    @ShellMethod(value = "Add author", key = {"aa", "add author" })
    public void addAuthor(@ShellOption String name) {
        boolean result = as.addAuthor(name);
        if (result)
            io.printString("Автор добавлен!", null);
    }

    @ShellMethod(value = "Get all genres", key = {"gag", "get all genres"})
    public void getAllGenres() {
        List<Genre> genres = gs.getAllGenres();
        if (genres != null)
            gps.printListGenres(genres);
    }

    @ShellMethod(value = "Get comment by id", key = {"gci", "get comment"})
    public void getCommentById(@ShellOption String id) {
        Comment comment = cs.getCommentById(id);
        if (comment != null)
            cps.printComment(comment);
    }

    @ShellMethod(value = "Get all comments by book id", key = {"gac", "get all comments"})
    public void getAllCommentsByBookId(@ShellOption String id) {
        List<Comment> comments = cs.getAllCommentsByBookId(id);
        if (comments != null)
            cps.printListComments(comments);
    }

    @ShellMethod(value = "Add comment by book id", key = {"aci", "add comment" })
    public void addCommentByBookId(@ShellOption String text, @ShellOption String id) {
        boolean result = cs.addCommentByBookId(text, id);
        if (result)
            io.printString("Комментарий добавлен!", null);
    }

    @ShellMethod(value = "Update comment by id", key = {"uci", "update comment" })
    public void updateCommentById(@ShellOption String text, @ShellOption String id) {
        boolean result = cs.updateCommentById(text, id);
        if (result)
            io.printString("Комментарий обновлен!", null);
    }

    @ShellMethod(value = "Delete the comment", key = {"dc", "delete comment"})
    public void deleteCommentById(@ShellOption String id) {
        boolean result = cs.deleteCommentById(id);
        if (result)
            io.printString("Комментарий удален!", null);
    }*/
}
