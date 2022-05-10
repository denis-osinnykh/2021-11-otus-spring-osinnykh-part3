package my.spring.service.comment;

import lombok.RequiredArgsConstructor;
import my.spring.domain.Book;
import my.spring.domain.Comment;
import my.spring.repositories.BookRepository;
import my.spring.repositories.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentJpa;
    private final BookRepository bookJpa;

    @Transactional(readOnly = true)
    public Comment getCommentById(long id) {
        try {
            return commentJpa.findCommentById(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional(readOnly = true)
    public List<Comment> getAllCommentsByBookId(long id) {
        try {
            return commentJpa.findAllByBookId(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public boolean addCommentByBookId(String text, long bookId) {
        try {
            Book book = bookJpa.findBookById(bookId);
            if (book == null) {
                return false;
            }
            Comment newComment = new Comment(0, text, book);

            commentJpa.save(newComment);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    public boolean updateCommentById(String text, long commentId) {
        try {
            Comment comment = commentJpa.findCommentById(commentId);
            if (comment == null) {
                return false;
            }

            comment.setText(text);
            commentJpa.save(comment);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    public boolean deleteCommentById(long id) {
        try {
            commentJpa.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
