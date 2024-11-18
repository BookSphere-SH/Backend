package spherehub.booksphere_platform.profile.domain.model.aggregates;

import lombok.Getter;
import spherehub.booksphere_platform.profile.domain.model.commands.CreateProfileCommand;
import spherehub.booksphere_platform.profile.domain.model.valueobjects.*;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Profile {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private ProfileName name;

    @Embedded
    private ProfileBirthday birthday;

    @Embedded
    private ProfileGender gender;

    @Embedded
    private ProfileFavoriteBook favoriteBook;

    @Embedded
    private ProfileRegisterDate registerDate;

    @Embedded
    private ProfileEmail email;

    @Embedded
    private ProfileDescription description;

    @Getter
    @ElementCollection
    private List<String> library;

    // Constructor for CreateProfileCommand
    public Profile(CreateProfileCommand command) {
        this.name = new ProfileName(command.name());
        this.birthday = new ProfileBirthday(command.birthday());
        this.gender = new ProfileGender(command.gender());
        this.favoriteBook = new ProfileFavoriteBook(command.favoriteBook());
        this.registerDate = new ProfileRegisterDate(command.registerDate());
        this.email = new ProfileEmail(command.email());
        this.description = new ProfileDescription(command.description());
        this.library = command.library();
    }

    // Default constructor for JPA
    protected Profile() {}

    // Update information method
    public void updateInformation(String name, LocalDate birthday, String gender, String favoriteBook, LocalDate registerDate, String email, String description, List<String> library) {
        this.name = new ProfileName(name);
        this.birthday = new ProfileBirthday(birthday);
        this.gender = new ProfileGender(gender);
        this.favoriteBook = new ProfileFavoriteBook(favoriteBook);
        this.registerDate = new ProfileRegisterDate(registerDate);
        this.email = new ProfileEmail(email);
        this.description = new ProfileDescription(description);
        this.library = library;
    }

    public String getName() {
        return name.name();
    }

    public LocalDate getBirthday() {
        return birthday.birthday();
    }

    public String getGender() {
        return gender.gender();
    }

    public String getFavoriteBook() {
        return favoriteBook.favoriteBook();
    }

    public LocalDate getRegisterDate() {
        return registerDate.registerDate();
    }

    public String getEmail() {
        return email.email();
    }

    public String getDescription() {
        return description.description();
    }

}