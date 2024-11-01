package spherehub.booksphere_platform.store.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record BookAuthor(String author) {
    public BookAuthor() {
        this(null);
    }
    public BookAuthor {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be null or blank");
        }
        if (author.length() > 50) {
            throw new IllegalArgumentException("Author name must not exceed 50 characters");
        }
    }
}
