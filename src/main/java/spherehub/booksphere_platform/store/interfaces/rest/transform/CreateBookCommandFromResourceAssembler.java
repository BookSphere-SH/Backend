package spherehub.booksphere_platform.store.interfaces.rest.transform;

import spherehub.booksphere_platform.store.domain.model.commands.CreateBookCommand;
import spherehub.booksphere_platform.store.interfaces.rest.resources.CreateBookResource;

public class CreateBookCommandFromResourceAssembler {
    public static CreateBookCommand toCommandFromResource(CreateBookResource resource) {
        return new CreateBookCommand(resource.title(), resource.author(), resource.categories(),
                resource.description(), resource.price(), resource.formats());
    }
}
