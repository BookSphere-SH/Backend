package spherehub.booksphere_platform.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProfileFavoriteBook(String favoriteBook) {
    public ProfileFavoriteBook() {
        this(null);
    }
    public ProfileFavoriteBook {
        if (favoriteBook == null || favoriteBook.isBlank()) {
            throw new IllegalArgumentException("Favorite book cannot be null or blank");
        }
        if (favoriteBook.length() > 100) {
            throw new IllegalArgumentException("Favorite book must not exceed 100 characters");
        }
    }
}