package my.spring.service.comment;

import lombok.RequiredArgsConstructor;
import my.spring.domain.Comment;
import my.spring.service.InputOutputService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentPrintServiceImpl implements CommentPrintService {
    private final InputOutputService io;

    public void printComment(Comment comment) {
        io.printString("Комментарий: %s, код комментария: %s, код книги: %s", new Object[] { comment.getText(), comment.getId(), comment.getBook().getId() });
    }

    public void printListComments(List<Comment> comments) {
        for (Comment comment: comments) {
            printComment(comment);
        }

        if (comments.stream().count() == 0)
            io.printString("Список пуст!", null);
    }
}
