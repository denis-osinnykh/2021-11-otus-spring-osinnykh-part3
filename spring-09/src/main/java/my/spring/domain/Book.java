package my.spring.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@RequiredArgsConstructor
@Entity
@Table(name = "book")
@NamedEntityGraph(name = "books-entity-graph",
        attributeNodes = {@NamedAttributeNode("author"),
                        @NamedAttributeNode("genre")})
public class Book {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Getter
    @Column(name = "name", nullable = false)
    private String name;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public Book(String name, @Nullable Author author, @Nullable Genre genre){
       this.name = name;
       this.author = author;
       this.genre = genre;
    }

    public Book(long id, String name, @Nullable Author author, @Nullable Genre genre){
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
    }
}
