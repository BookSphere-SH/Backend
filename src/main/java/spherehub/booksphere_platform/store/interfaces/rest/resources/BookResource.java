package spherehub.booksphere_platform.store.interfaces.rest.resources;

import java.util.List;

public record BookResource(int id, String title, String author, List<String> categories,
                           String description, float price, List<String> formats) {
}
