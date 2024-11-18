package spherehub.booksphere_platform.profile.application.internal.commandservices;

import org.springframework.stereotype.Service;
import spherehub.booksphere_platform.profile.domain.model.aggregates.Profile;
import spherehub.booksphere_platform.profile.domain.model.commands.CreateProfileCommand;
import spherehub.booksphere_platform.profile.domain.model.commands.DeleteProfileCommand;
import spherehub.booksphere_platform.profile.domain.model.commands.UpdateProfileCommand;
import spherehub.booksphere_platform.profile.domain.model.valueobjects.ProfileName;
import spherehub.booksphere_platform.profile.domain.services.ProfileCommandService;
import spherehub.booksphere_platform.profile.infrastructure.persistence.jpa.repositories.ProfileRepository;

import java.util.Optional;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {

    private final ProfileRepository profileRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Long handle(CreateProfileCommand command) {

        var name = new ProfileName(command.name());
        if (this.profileRepository.existsByName(name)) {
            throw new IllegalArgumentException("Profile with name " + name.name() + " already exists");
        }

        var profile = new Profile(command);
        try {
            this.profileRepository.save(profile);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving profile: " + e.getMessage());
        }
        return profile.getId();
    }

    @Override
    public Optional<Profile> handle(UpdateProfileCommand command) {
        var profileId = command.profileId();
        var name = new ProfileName(command.name());
        if (this.profileRepository.existsByNameAndIdIsNot(name, profileId)) {
            throw new IllegalArgumentException("Profile with name " + name.name() + " already exists");
        }

        // If the profile does not exist, throw an exception
        if (!this.profileRepository.existsById(profileId)) {
            throw new IllegalArgumentException("Profile with id " + profileId + " does not exist");
        }

        var profileToUpdate = this.profileRepository.findById(profileId).get();
        profileToUpdate.updateInformation(command.name(), command.birthday(), command.gender(),
                command.favoriteBook(), command.registerDate(), command.email(), command.description(), command.library());

        try {
            var updatedProfile = this.profileRepository.save(profileToUpdate);
            return Optional.of(updatedProfile);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating profile: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteProfileCommand command) {
        // If the profile does not exist, throw an exception
        if (!this.profileRepository.existsById(command.profileId())) {
            throw new IllegalArgumentException("Profile with id " + command.profileId() + " does not exist");
        }

        // Try to delete the profile, if an error occurs, throw an exception
        try {
            this.profileRepository.deleteById(command.profileId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting profile: " + e.getMessage());
        }
    }
}