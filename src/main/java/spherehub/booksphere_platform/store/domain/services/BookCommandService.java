package spherehub.booksphere_platform.store.domain.services;

import spherehub.booksphere_platform.store.domain.model.aggregates.Book;
import spherehub.booksphere_platform.store.domain.model.commands.CreateBookCommand;
import spherehub.booksphere_platform.store.domain.model.commands.DeleteBookCommand;
import spherehub.booksphere_platform.store.domain.model.commands.UpdateBookCommand;

import java.util.Optional;

public interface BookCommandService {
    Long handle(CreateBookCommand command);
    Optional<Book> handle(UpdateBookCommand command);
    void handle(DeleteBookCommand command);
}
