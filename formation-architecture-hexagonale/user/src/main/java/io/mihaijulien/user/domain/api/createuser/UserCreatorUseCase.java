package io.mihaijulien.user.domain.api.createuser;

import io.mihaijulien.user.domain.User;
import io.mihaijulien.user.domain.spi.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCreatorUseCase implements CreateUserUseCase{

    private final UserRepository userRepository;

    public UserCreatorUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(String firstName, String lastName) {
        if(isFirstNameOrLastNameNotFilled(firstName, lastName)){
            throw new IllegalArgumentException("Il faut avoir un nom et un prénom.");
        }
        User user = new User(firstName, lastName);
        this.userRepository.create(user);
    }

    private static boolean isFirstNameOrLastNameNotFilled(String firstName, String lastName) {
        return firstName == null  || lastName == null || firstName.isBlank() || lastName.isBlank();
    }
}
