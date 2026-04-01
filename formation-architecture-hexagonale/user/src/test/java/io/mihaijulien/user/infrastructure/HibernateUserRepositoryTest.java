package io.mihaijulien.user.infrastructure;

import io.mihaijulien.user.domain.User;
import io.mihaijulien.user.domain.spi.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HibernateUserRepositoryTest {

    private final static User JULIEN = new User("Julien", "Mihai");

    @Autowired
    private UserRepository repository;

    @Autowired
    private HibernateUserManager hibernateUserManager;

    @BeforeEach
    public void setUp(){
        hibernateUserManager.deleteAll();
    }

    @Test
    void shouldCreateUser() {
        Assertions.assertEquals(0, repository.findAll().size());
        repository.create(JULIEN);
        Assertions.assertEquals(1, repository.findAll().size());
    }
}
