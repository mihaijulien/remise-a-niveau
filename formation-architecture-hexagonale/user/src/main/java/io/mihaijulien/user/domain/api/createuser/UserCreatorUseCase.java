package io.mihaijulien.user.domain.api.createuser;

import io.mihaijulien.user.domain.User;
import io.mihaijulien.user.domain.spi.UserRepository;

public class UserCreatorUseCase implements CreateUserUseCase{

    private final UserRepository userRepository;

    public UserCreatorUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(String firstName, String lastName) {
        User user = new User(firstName, lastName);
        this.userRepository.create(user);
    }
}
