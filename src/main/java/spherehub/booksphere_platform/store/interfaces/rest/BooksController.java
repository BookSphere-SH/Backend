package spherehub.booksphere_platform.store.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spherehub.booksphere_platform.store.domain.model.commands.DeleteBookCommand;
import spherehub.booksphere_platform.store.domain.model.queries.GetAllBooksQuery;
import spherehub.booksphere_platform.store.domain.model.queries.GetBookByIdQuery;
import spherehub.booksphere_platform.store.domain.services.BookCommandService;
import spherehub.booksphere_platform.store.domain.services.BookQueryService;
import spherehub.booksphere_platform.store.interfaces.rest.resources.CreateBookResource;
import spherehub.booksphere_platform.store.interfaces.rest.resources.BookResource;
import spherehub.booksphere_platform.store.interfaces.rest.transform.CreateBookCommandFromResourceAssembler;
import spherehub.booksphere_platform.store.interfaces.rest.transform.BookResourceFromEntityAssembler;
import spherehub.booksphere_platform.store.interfaces.rest.transform.UpdateBookCommandFromResourceAssembler;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping(value = "/api/v1/books", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Books", description = "Book Management Endpoints")
public class BooksController {

    private final BookQueryService bookQueryService;
    private final BookCommandService bookCommandService;

    public BooksController(BookQueryService bookQueryService, BookCommandService bookCommandService) {
        this.bookQueryService = bookQueryService;
        this.bookCommandService = bookCommandService;
    }

    @PostMapping
    public ResponseEntity<BookResource> createBook(@RequestBody CreateBookResource resource) {

        var createBookCommand = CreateBookCommandFromResourceAssembler
                .toCommandFromResource(resource);
        var bookId = this.bookCommandService.handle(createBookCommand);

        if (bookId.equals(0L)) {
            return ResponseEntity.badRequest().build();
        }

        var getBookByIdQuery = new GetBookByIdQuery(bookId.intValue());
        var optionalBook = this.bookQueryService.handle(getBookByIdQuery);

        var bookResource = BookResourceFromEntityAssembler.toResourceFromEntity(optionalBook.get());
        return new ResponseEntity<>(bookResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookResource>> getAllBooks() {
        var getAllBooksQuery = new GetAllBooksQuery();
        var books = this.bookQueryService.handle(getAllBooksQuery);
        var bookResources = books.stream()
                .map(BookResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(bookResources);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookResource> getBookById(@PathVariable int bookId) {
        var getBookByIdQuery = new GetBookByIdQuery(bookId);
        var optionalBook = this.bookQueryService.handle(getBookByIdQuery);
        if (optionalBook.isEmpty())
            return ResponseEntity.badRequest().build();
        var bookResource = BookResourceFromEntityAssembler.toResourceFromEntity(optionalBook.get());
        return ResponseEntity.ok(bookResource);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookResource> updateBook(@PathVariable int bookId, @RequestBody BookResource resource) {
        var updateBookCommand = UpdateBookCommandFromResourceAssembler.toCommandFromResource(bookId, resource);
        var optionalBook = this.bookCommandService.handle(updateBookCommand);

        if (optionalBook.isEmpty())
            return ResponseEntity.badRequest().build();
        var bookResource = BookResourceFromEntityAssembler.toResourceFromEntity(optionalBook.get());
        return ResponseEntity.ok(bookResource);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable int bookId) {
        var deleteBookCommand = new DeleteBookCommand(bookId);
        this.bookCommandService.handle(deleteBookCommand);
        return ResponseEntity.noContent().build();
    }
}
