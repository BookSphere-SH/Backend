package spherehub.booksphere_platform.store.application.internal.queryservices;

import org.springframework.stereotype.Service;
import spherehub.booksphere_platform.store.domain.model.aggregates.Book;
import spherehub.booksphere_platform.store.domain.model.queries.GetAllBooksQuery;
import spherehub.booksphere_platform.store.domain.model.queries.GetBookByIdQuery;
import spherehub.booksphere_platform.store.domain.model.queries.GetBookByTitleQuery;
import spherehub.booksphere_platform.store.domain.services.BookQueryService;
import spherehub.booksphere_platform.store.infrastructure.persistence.jpa.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookQueryServiceImpl implements BookQueryService {

    private final BookRepository bookRepository;

    public BookQueryServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> handle(GetAllBooksQuery query) {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> handle(GetBookByIdQuery query) {
        return this.bookRepository.findById(query.bookId());
    }

    @Override
    public Optional<Book> handle(GetBookByTitleQuery query) {
        return this.bookRepository.findByTitle(query.title());
    }
}
