package io.mihaijulien.user.domain.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateUserTest {

    private CreateUserUseCase useCase = new UserCreator();
    private UserRepository repository = new InMemoryUserRepository();

    @Test
    void shouldCreateUser() {
        Assertions.assertEquals(0, repository.findAll().size());
        useCase.create("Mihai", "Jlien");
        Assertions.assertEquals(1, repository.findAll().size());
    }
}
