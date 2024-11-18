package spherehub.booksphere_platform.profile.domain.model.commands;

import java.time.LocalDate;
import java.util.List;

public record CreateProfileCommand(String name, LocalDate birthday, String gender, String favoriteBook, LocalDate registerDate, String email, String description, List<String> library) {
}