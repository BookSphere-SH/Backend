package spherehub.booksphere_platform.profile.domain.services;

import spherehub.booksphere_platform.profile.domain.model.aggregates.Profile;
import spherehub.booksphere_platform.profile.domain.model.queries.GetAllProfilesQuery;
import spherehub.booksphere_platform.profile.domain.model.queries.GetProfileByIdQuery;
import spherehub.booksphere_platform.profile.domain.model.queries.GetProfileByNameQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    List<Profile> handle(GetAllProfilesQuery query);
    Optional<Profile> handle(GetProfileByIdQuery query);
    Optional<Profile> handle(GetProfileByNameQuery query);
}
