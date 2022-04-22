package my.spring.service.comment;

import my.spring.domain.Comment;

import java.util.List;

public interface CommentService {
    Comment getCommentById(long id);

    List<Comment> getAllCommentsByBookId(long id);

    boolean addCommentByBookId(String text, long book_id);

    boolean updateCommentById(String text, long comment_id);

    boolean deleteCommentById(long comment_id);
}
