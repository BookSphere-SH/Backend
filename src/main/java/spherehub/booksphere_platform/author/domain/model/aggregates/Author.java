package spherehub.booksphere_platform.author.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import spherehub.booksphere_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import spherehub.booksphere_platform.author.domain.model.valueobjects.AuthorId;
import spherehub.booksphere_platform.author.domain.model.valueobjects.BookCode;

@Entity
@Table(name = "authors")
public class Author extends AuditableAbstractAggregateRoot<Author> {

    @Getter
    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name = "bookCode", column = @Column(name = "book_code", length = 36, nullable = false))
    })
    private final BookCode bookCode;

    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name = "profileId", column = @Column(name = "author_id", nullable = false))
    })
    private AuthorId authorId;

    //---------------------------------------------------
    public Author() {
        this.bookCode = new BookCode();
    }

    public Author(Long authorId) {
        this();
        this.authorId = new AuthorId(authorId);
    }

    public Author(AuthorId authorId) {
        this();
        this.authorId = authorId;
    }

    public Long getAuthorId() {
        return authorId.authorId();
    }
}
