package spherehub.booksphere_platform.profile.interfaces.rest.resources;

import java.time.LocalDate;
import java.util.List;

public record ProfileResource(Long id, String name, LocalDate birthday, String gender,
                              String favoriteBook, LocalDate registerDate, String email,
                              String description, List<String> library) {
}