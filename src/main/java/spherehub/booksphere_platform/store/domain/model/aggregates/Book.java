package spherehub.booksphere_platform.store.domain.model.aggregates;

import jakarta.persistence.*;
import spherehub.booksphere_platform.store.domain.model.commands.CreateBookCommand;
import spherehub.booksphere_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import spherehub.booksphere_platform.store.domain.model.valueobjects.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book extends AuditableAbstractAggregateRoot<Book> {

    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name = "book_title", column = @Column(name = "title", length = 50, nullable = false))
    })
    private BookTitle title;

    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name = "book_author", column = @Column(name = "author", length = 50, nullable = false))
    })
    private BookAuthor author;

    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name = "book_categories", column = @Column(name = "categories"))
    })
    private BookCategories categories;

    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name = "book_description", column = @Column(name = "description", length = 1000, nullable = false))
    })
    private BookDescription description;

    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name = "book_price", column = @Column(name = "price"))
    })
    private BookPrice price;

    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name = "book_formats", column = @Column(name = "formats"))
    })
    private BookFormats formats;

    //---------------------------------------------------
    public Book(String title, String author, List<String> categories, String description, Float price, List<String> formats) {
        this.title = new BookTitle(title);
        this.author = new BookAuthor(author);
        this.categories = new BookCategories(categories);
        this.description = new BookDescription(description);
        this.price = new BookPrice(price);
        this.formats = new BookFormats(formats);
    }

    public Book() {
    }

    // Title
    public void updateBookTitle(String title) {
        this.title = new BookTitle(title);
    }

    public String getTitle() {
        return title.title();
    }

    // Author
    public void updateBookAuthor(String author) {
        this.author = new BookAuthor(author);
    }

    public String getAuthor() {
        return author.author();
    }

    // Categories
    public void updateBookCategories(List<String> categories) {
        this.categories = new BookCategories(categories);
    }

    public List<String> getCategories() {
        return categories.categories();
    }

    // Description
    public void updateBookDescription(String description) {
        this.description = new BookDescription(description);
    }

    public String getDescription() {
        return description.description();
    }

    // Price
    public void updateBookPrice(float price) {
        this.price = new BookPrice(price);
    }

    public float getPrice() {
        return price.price();
    }

    // Formats
    public void updateBookFormats(List<String> formats) {
        this.formats = new BookFormats(formats);
    }

    public List<String> getFormats() {
        return formats.formats();
    }

    //---------------------------------------------------
    public Book(CreateBookCommand command) {
        this.title = new BookTitle(command.title());
        this.author = new BookAuthor(command.author());
        this.categories = new BookCategories(command.categories());
        this.description = new BookDescription(command.description());
        this.price = new BookPrice(command.price());
        this.formats = new BookFormats(command.formats());
    }

    public Book updateInformation(String title, String author, List<String> categories, String description, float price, List<String> formats) {
        this.title = new BookTitle(title);
        this.author = new BookAuthor(author);
        this.categories = new BookCategories(categories);
        this.description = new BookDescription(description);
        this.price = new BookPrice(price);
        this.formats = new BookFormats(formats);
        return this;
    }
}
