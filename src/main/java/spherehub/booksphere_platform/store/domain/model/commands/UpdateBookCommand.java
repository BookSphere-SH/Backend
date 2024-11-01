package spherehub.booksphere_platform.store.domain.model.commands;

import java.util.List;

public record UpdateBookCommand(int bookId, String title, String author, List<String> categories, String description, float price, List<String> formats) {
}
