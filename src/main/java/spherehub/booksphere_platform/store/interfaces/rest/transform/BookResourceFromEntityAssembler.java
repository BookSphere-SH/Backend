package spherehub.booksphere_platform.store.interfaces.rest.transform;

import spherehub.booksphere_platform.store.domain.model.aggregates.Book;
import spherehub.booksphere_platform.store.interfaces.rest.resources.BookResource;

public record BookResourceFromEntityAssembler() {
    public static BookResource toResourceFromEntity(Book entity) {
        return new BookResource(entity.getId().intValue(), entity.getTitle(), entity.getAuthor(),
                entity.getCategories(), entity.getDescription(), entity.getPrice(), entity.getFormats());
    }
}
