package spherehub.booksphere_platform.profile.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spherehub.booksphere_platform.profile.domain.model.aggregates.Profile;
import spherehub.booksphere_platform.profile.domain.model.valueobjects.ProfileName;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    boolean existsByName(ProfileName name);
    boolean existsByNameAndIdIsNot(ProfileName name, Long id);
    Optional<Profile> findByName(String name);
}