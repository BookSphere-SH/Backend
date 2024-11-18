package spherehub.booksphere_platform.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.util.List;

@Embeddable
public record ProfileLibrary(List<String> library) {
    public ProfileLibrary() {
        this(null);
    }
    public ProfileLibrary {
        if (library == null) {
            throw new IllegalArgumentException("Library cannot be null");
        }
    }
}