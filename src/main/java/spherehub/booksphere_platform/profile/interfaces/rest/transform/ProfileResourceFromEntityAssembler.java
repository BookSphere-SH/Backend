package spherehub.booksphere_platform.profile.interfaces.rest.transform;

import spherehub.booksphere_platform.profile.interfaces.rest.resources.ProfileResource;
import spherehub.booksphere_platform.profile.domain.model.aggregates.Profile;

public record ProfileResourceFromEntityAssembler() {
    public static ProfileResource toResourceFromEntity(Profile entity) {
        return new ProfileResource(entity.getId(), entity.getName(), entity.getBirthday(),
                entity.getGender(), entity.getFavoriteBook(), entity.getRegisterDate(),
                entity.getEmail(), entity.getDescription(), entity.getLibrary());
    }
}