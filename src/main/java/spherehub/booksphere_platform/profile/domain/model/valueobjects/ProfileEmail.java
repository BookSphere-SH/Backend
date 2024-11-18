package spherehub.booksphere_platform.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProfileEmail(String email) {
    public ProfileEmail() {
        this(null);
    }
    public ProfileEmail {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
        if (email.length() > 100) {
            throw new IllegalArgumentException("Email must not exceed 100 characters");
        }
    }
}