package my.spring.service.comment;

import lombok.RequiredArgsConstructor;
import my.spring.domain.Book;
import my.spring.domain.Comment;
import my.spring.repositories.BookRepository;
import my.spring.repositories.CommentRepository;
import my.spring.service.InputOutputService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentJpa;
    private final BookRepository bookJpa;
    private final InputOutputService io;

    @Transactional(readOnly = true)
    public Comment getCommentById(long id) {
        try {
            return commentJpa.findCommentById(id);
        } catch (Exception e) {
            io.printString("Ошибка выполнения запроса! Комментарий не найден!\n " + e.getMessage(), null);
            return null;
        }
    }

    @Transactional(readOnly = true)
    public List<Comment> getAllCommentsByBookId(long id) {
        try {
            return commentJpa.findAllByBookId(id);
        } catch (Exception e) {
            io.printString("Ошибка выполнения запроса! Комментарии не найдены!\n " + e.getMessage(), null);
            return null;
        }
    }

    @Transactional
    public boolean addCommentByBookId(String text, long bookId) {
        try {
            Book book = bookJpa.findBookById(bookId);
            if (book == null) {
                io.printString("Ошибка выполнения запроса! Книга не найдена!\n ", null);
                return false;
            }
            Comment newComment = new Comment(0, text, book);

            commentJpa.save(newComment);
            return true;
        } catch (Exception e) {
            io.printString("Ошибка выполнения запроса! Комментарий не добавлен!\n " + e.getMessage(), null);
            return false;
        }
    }

    @Transactional
    public boolean updateCommentById(String text, long commentId) {
        try {
            Comment comment = commentJpa.findCommentById(commentId);
            if (comment == null) {
                io.printString("Ошибка выполнения запроса! Комментарий не найден!\n ", null);
                return false;
            }

            comment.setText(text);
            commentJpa.save(comment);
            return true;
        } catch (Exception e) {
            io.printString("Ошибка выполнения запроса! Комментарий не добавлен!\n " + e.getMessage(), null);
            return false;
        }
    }

    @Transactional
    public boolean deleteCommentById(long id) {
        try {
            commentJpa.deleteById(id);
            return true;
        } catch (Exception e) {
            io.printString("Ошибка выполнения запроса! Комментарий не удален!\n " + e.getMessage(), null);
            return false;
        }
    }
}
