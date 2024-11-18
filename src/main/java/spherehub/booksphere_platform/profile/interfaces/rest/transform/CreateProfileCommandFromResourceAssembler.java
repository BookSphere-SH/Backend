package spherehub.booksphere_platform.profile.interfaces.rest.transform;

import spherehub.booksphere_platform.profile.interfaces.rest.resources.CreateProfileResource;
import spherehub.booksphere_platform.profile.domain.model.commands.CreateProfileCommand;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateProfileCommand(resource.name(), resource.birthday(), resource.gender(),
                resource.favoriteBook(), resource.registerDate(), resource.email(), resource.description(), resource.library());
    }
}