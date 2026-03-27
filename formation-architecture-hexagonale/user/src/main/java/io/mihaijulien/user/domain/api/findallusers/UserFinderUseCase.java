package io.mihaijulien.user.domain.api.findallusers;

import io.mihaijulien.user.domain.User;
import io.mihaijulien.user.domain.spi.UserRepository;

import java.util.List;

public class UserFinderUseCase implements FindAllUsersUseCase{

    private final UserRepository userRepository;

    public UserFinderUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
