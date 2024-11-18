package spherehub.booksphere_platform.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public record ProfileBirthday(LocalDate birthday) {
    public ProfileBirthday() {
        this(null);
    }
    public ProfileBirthday {
        if (birthday == null) {
            throw new IllegalArgumentException("Birthday cannot be null");
        }
    }
}