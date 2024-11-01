package spherehub.booksphere_platform.store.interfaces.rest.transform;

import spherehub.booksphere_platform.store.domain.model.commands.UpdateBookCommand;
import spherehub.booksphere_platform.store.interfaces.rest.resources.BookResource;

public record UpdateBookCommandFromResourceAssembler() {
    public static UpdateBookCommand toCommandFromResource(int bookId, BookResource resource) {
        return new UpdateBookCommand(bookId, resource.title(), resource.author(), resource.categories(),
                resource.description(), resource.price(), resource.formats());
    }
}
