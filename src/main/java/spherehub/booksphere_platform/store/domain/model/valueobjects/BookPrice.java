package spherehub.booksphere_platform.store.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record BookPrice(Float price) {
    public BookPrice() {
        this(null);
    }

    public BookPrice {
        if (price == null) {
            throw new IllegalArgumentException("Price cannot be null or blank");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price must be a positive value");
        }
    }
}
