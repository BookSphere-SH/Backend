package spherehub.booksphere_platform.author.domain.model.valueobjects;

import java.util.UUID;

public record BookCode(String bookCode) {
    public BookCode() {
        this(UUID.randomUUID().toString());
    }
    public BookCode {
        if (bookCode == null || bookCode.isBlank()) {
            throw new IllegalArgumentException("Book code cannot be null or blank");
        }
        if (bookCode.length() != 36) {
            throw new IllegalArgumentException("Book code must be 36 characters long");
        }
        if (!bookCode.matches("[a-f0-9]{8}-([a-f0-9]{4}-){3}[a-f0-9]{12}")) {
            throw new IllegalArgumentException("Book code must be a valid UUID");
        }
    }
}
