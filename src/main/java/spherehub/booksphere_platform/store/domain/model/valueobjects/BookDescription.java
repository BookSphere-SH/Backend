package spherehub.booksphere_platform.store.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record BookDescription(String description) {
    public BookDescription() {
        this(null);
    }

    public BookDescription {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
        if (description.length() > 1000) {
            throw new IllegalArgumentException("Description must not exceed 1000 characters");
        }
    }
}
