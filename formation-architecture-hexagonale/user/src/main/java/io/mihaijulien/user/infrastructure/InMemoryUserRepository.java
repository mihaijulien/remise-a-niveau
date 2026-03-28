package io.mihaijulien.user.infrastructure;

import io.mihaijulien.user.domain.User;
import io.mihaijulien.user.domain.spi.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryUserRepository implements UserRepository {

    private List<User> users = new ArrayList<>();

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void create(User user) {
        users.add(user);
    }
}
