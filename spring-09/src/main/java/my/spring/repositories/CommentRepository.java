package my.spring.repositories;

import my.spring.domain.Comment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @EntityGraph(value = "comments-entity-graph")
    Comment findCommentById(long id);

    List<Comment> findAllByBookId(long id);
}
