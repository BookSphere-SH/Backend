package spherehub.booksphere_platform.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProfileGender(String gender) {
    public ProfileGender() {
        this(null);
    }
    public ProfileGender {
        if (gender == null || gender.isBlank()) {
            throw new IllegalArgumentException("Gender cannot be null or blank");
        }
        if (gender.length() > 10) {
            throw new IllegalArgumentException("Gender must not exceed 10 characters");
        }
    }
}