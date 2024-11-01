package spherehub.booksphere_platform.store.application.internal.commandservices;

import org.springframework.stereotype.Service;
import spherehub.booksphere_platform.store.domain.model.aggregates.Book;
import spherehub.booksphere_platform.store.domain.model.commands.CreateBookCommand;
import spherehub.booksphere_platform.store.domain.model.commands.DeleteBookCommand;
import spherehub.booksphere_platform.store.domain.model.commands.UpdateBookCommand;
import spherehub.booksphere_platform.store.domain.model.valueobjects.BookTitle;
import spherehub.booksphere_platform.store.domain.services.BookCommandService;
import spherehub.booksphere_platform.store.infrastructure.persistence.jpa.repositories.BookRepository;

import java.util.Optional;

@Service
public class BookCommandServiceImpl implements BookCommandService {

    private final BookRepository bookRepository;

    public BookCommandServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Long handle(CreateBookCommand command) {

        var title = new BookTitle(command.title());
        if (this.bookRepository.existsByTitle(title)) {
            throw new IllegalArgumentException("Book with title " + title.title() + " already exists");
        }

        var book = new Book(command);
        try {
            this.bookRepository.save(book);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving book: " + e.getMessage());
        }
        return book.getId();
    }

    @Override
    public Optional<Book> handle(UpdateBookCommand command) {
        var bookId = command.bookId();
        var title = new BookTitle(command.title());
        if (this.bookRepository.existsByTitleAndIdIsNot(title, bookId)) {
            throw new IllegalArgumentException("Profile with title " + title.title() + " already exists");
        }

        // If the book does not exist, throw an exception
        if (!this.bookRepository.existsById(bookId)) {
            throw new IllegalArgumentException("Book with id " + bookId + " does not exist");
        }

        var bookToUpdate = this.bookRepository.findById(bookId).get();
        bookToUpdate.updateInformation(command.title(), command.author(), command.categories(),
                command.description(), command.price(), command.formats());

        try {
            var updatedBook = this.bookRepository.save(bookToUpdate);
            return Optional.of(updatedBook);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating book: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteBookCommand command) {
        // If the book does not exist, throw an exception
        if (!this.bookRepository.existsById(command.bookId())) {
            throw new IllegalArgumentException("Book with id " + command.bookId() + " does not exist");
        }

        // Try to delete the book, if an error occurs, throw an exception
        try {
            this.bookRepository.deleteById(command.bookId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting book: " + e.getMessage());
        }
    }
}
