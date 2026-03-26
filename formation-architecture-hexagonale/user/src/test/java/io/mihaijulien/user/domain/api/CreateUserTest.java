package io.mihaijulien.user.domain.api;

import io.mihaijulien.user.domain.api.createuser.CreateUserUseCase;
import io.mihaijulien.user.domain.api.createuser.UserCreatorUseCase;
import io.mihaijulien.user.domain.spi.InMemoryUserRepository;
import io.mihaijulien.user.domain.spi.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateUserTest {

    private UserRepository repository = new InMemoryUserRepository();
    private CreateUserUseCase useCase = new UserCreatorUseCase(repository);

    @Test
    void shouldCreateUser() {
        Assertions.assertEquals(0, repository.findAll().size());
        useCase.create("Mihai", "Jlien");
        Assertions.assertEquals(1, repository.findAll().size());
    }
}
