package spherehub.booksphere_platform.store.domain.model.commands;

import java.util.List;

public record CreateBookCommand(String title, String author, List<String> categories, String description, float price, List<String> formats) {
}
