package spherehub.booksphere_platform.profile.interfaces.rest.transform;

import spherehub.booksphere_platform.profile.interfaces.rest.resources.ProfileResource;
import spherehub.booksphere_platform.profile.domain.model.commands.UpdateProfileCommand;

public record UpdateProfileCommandFromResourceAssembler() {
    public static UpdateProfileCommand toCommandFromResource(Long profileId, ProfileResource resource) {
        return new UpdateProfileCommand(profileId, resource.name(), resource.birthday(), resource.gender(),
                resource.favoriteBook(), resource.registerDate(), resource.email(), resource.description(), resource.library());
    }
}