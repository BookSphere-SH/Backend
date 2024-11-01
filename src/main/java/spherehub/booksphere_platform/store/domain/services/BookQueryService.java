package spherehub.booksphere_platform.store.domain.services;

import spherehub.booksphere_platform.store.domain.model.aggregates.Book;
import spherehub.booksphere_platform.store.domain.model.queries.GetAllBooksQuery;
import spherehub.booksphere_platform.store.domain.model.queries.GetBookByTitleQuery;
import spherehub.booksphere_platform.store.domain.model.queries.GetBookByIdQuery;

import java.util.List;
import java.util.Optional;

public interface BookQueryService {
    List<Book> handle(GetAllBooksQuery query);
    Optional<Book> handle(GetBookByIdQuery query);
    Optional<Book> handle(GetBookByTitleQuery query);
}
