package spherehub.booksphere_platform.store.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.List;

@Embeddable
public record BookCategories(List<String> categories) {
    public BookCategories() {
        this(List.of());
    }
    public BookCategories {
        if (categories == null || categories.isEmpty()) {
            throw new IllegalArgumentException("Categories cannot be null or empty");
        }
    }
}
