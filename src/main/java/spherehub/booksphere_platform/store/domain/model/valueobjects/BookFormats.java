package spherehub.booksphere_platform.store.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.List;

@Embeddable
public record BookFormats(List<String> formats) {
    public BookFormats() {
        this(List.of());
    }
    public BookFormats {
        if (formats == null || formats.isEmpty()) {
            throw new IllegalArgumentException("Formats cannot be null or empty");
        }
    }
}
