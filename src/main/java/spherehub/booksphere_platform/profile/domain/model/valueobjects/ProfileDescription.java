package spherehub.booksphere_platform.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProfileDescription(String description) {
    public ProfileDescription() {
        this(null);
    }
    public ProfileDescription {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
        if (description.length() > 1000) {
            throw new IllegalArgumentException("Description must not exceed 1000 characters");
        }
    }
}