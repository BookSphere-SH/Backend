package spherehub.booksphere_platform.store.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spherehub.booksphere_platform.store.domain.model.aggregates.Book;
import spherehub.booksphere_platform.store.domain.model.valueobjects.BookTitle;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    boolean existsByTitle(BookTitle title);
    boolean existsByTitleAndIdIsNot(BookTitle title, int id);
    Optional<Book> findByTitle(String title);
}
