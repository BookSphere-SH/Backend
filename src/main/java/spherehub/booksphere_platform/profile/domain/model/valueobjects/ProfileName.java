package spherehub.booksphere_platform.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProfileName(String name) {
    public ProfileName() {
        this(null);
    }
    public ProfileName {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (name.length() > 50) {
            throw new IllegalArgumentException("Name must not exceed 50 characters");
        }
    }
}