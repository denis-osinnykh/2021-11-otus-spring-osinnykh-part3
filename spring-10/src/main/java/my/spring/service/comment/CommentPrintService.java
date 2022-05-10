package my.spring.service.comment;

import my.spring.domain.Comment;

import java.util.List;

public interface CommentPrintService {
    void printComment(Comment comment);

    void printListComments(List<Comment> comments);
}
