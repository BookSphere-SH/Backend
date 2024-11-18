package spherehub.booksphere_platform.profile.application.internal.queryservices;

import org.springframework.stereotype.Service;
import spherehub.booksphere_platform.profile.domain.model.aggregates.Profile;
import spherehub.booksphere_platform.profile.domain.model.queries.GetAllProfilesQuery;
import spherehub.booksphere_platform.profile.domain.model.queries.GetProfileByIdQuery;
import spherehub.booksphere_platform.profile.domain.model.queries.GetProfileByNameQuery;
import spherehub.booksphere_platform.profile.domain.services.ProfileQueryService;
import spherehub.booksphere_platform.profile.infrastructure.persistence.jpa.repositories.ProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {

    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return this.profileRepository.findAll();
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return this.profileRepository.findById(query.profileId());
    }

    @Override
    public Optional<Profile> handle(GetProfileByNameQuery query) {
        return this.profileRepository.findByName(query.name());
    }
}