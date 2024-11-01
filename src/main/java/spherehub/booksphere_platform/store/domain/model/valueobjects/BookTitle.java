package spherehub.booksphere_platform.store.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record BookTitle(String title) {
    public BookTitle() {
        this(null);
    }
    public BookTitle {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        if (title.length() > 50) {
            throw new IllegalArgumentException("Title must not exceed 50 characters");
        }
    }
}
