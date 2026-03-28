package io.mihaijulien.user.domain.api;

import io.mihaijulien.user.domain.User;
import io.mihaijulien.user.domain.api.findallusers.FindAllUsersUseCase;
import io.mihaijulien.user.domain.api.findallusers.UserFinderUseCase;
import io.mihaijulien.user.infrastructure.InMemoryUserRepository;
import io.mihaijulien.user.domain.spi.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FindAllUsersTest {

    private final static User JULIEN_USER = new User("JULIEN", "MIHAI");
    private final static User CRISTINA_USER = new User("CRISTINA", "MIHAI");

    private final UserRepository userRepository = new InMemoryUserRepository();
    private final FindAllUsersUseCase useCase = new UserFinderUseCase(userRepository);

    @Test
    void shouldRetrieveAllUsers(){
        givenExistingUser(JULIEN_USER);
        givenExistingUser(CRISTINA_USER);
        List<User> users = useCase.findAll();
        Assertions.assertEquals(2, users.size());
    }

    private void givenExistingUser(User user) {
        userRepository.create(user);
    }
}
