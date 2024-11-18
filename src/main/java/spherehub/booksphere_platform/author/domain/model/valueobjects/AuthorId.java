package spherehub.booksphere_platform.author.domain.model.valueobjects;

public record AuthorId(Long authorId) {
    public AuthorId {
        if (authorId < 0) {
            throw new IllegalArgumentException("Author authorId cannot be negative");
        }
    }

    public AuthorId() {
        this(0L);
    }
}
