package my.spring.domain;

import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@Entity
@Table(name = "comment")
@NamedEntityGraph(name = "comments-entity-graph",
        attributeNodes = {@NamedAttributeNode("book")})
public class Comment {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Getter
    @Setter
    @Column(name = "text")
    private String text;

    @Getter
    @ManyToOne(targetEntity = Book.class, fetch = FetchType.LAZY)
    private Book book;

    public Comment(long id, String text, Book book) {
        this.id = id;
        this.text = text;
        this.book = book;
    }
}