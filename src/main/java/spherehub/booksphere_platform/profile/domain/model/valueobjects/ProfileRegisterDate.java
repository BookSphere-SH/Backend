package spherehub.booksphere_platform.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public record ProfileRegisterDate(LocalDate registerDate) {
    public ProfileRegisterDate() {
        this(null);
    }
    public ProfileRegisterDate {
        if (registerDate == null) {
            throw new IllegalArgumentException("Register date cannot be null");
        }
    }
}