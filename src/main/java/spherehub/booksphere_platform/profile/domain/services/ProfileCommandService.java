package spherehub.booksphere_platform.profile.domain.services;

import spherehub.booksphere_platform.profile.domain.model.aggregates.Profile;
import spherehub.booksphere_platform.profile.domain.model.commands.CreateProfileCommand;
import spherehub.booksphere_platform.profile.domain.model.commands.DeleteProfileCommand;
import spherehub.booksphere_platform.profile.domain.model.commands.UpdateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
    Long handle(CreateProfileCommand command);
    Optional<Profile> handle(UpdateProfileCommand command);
    void handle(DeleteProfileCommand command);
}
