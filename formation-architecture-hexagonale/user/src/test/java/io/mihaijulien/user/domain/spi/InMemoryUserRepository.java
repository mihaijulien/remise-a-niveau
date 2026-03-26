package io.mihaijulien.user.domain.spi;

import io.mihaijulien.user.domain.User;

import java.util.List;

public class InMemoryUserRepository implements UserRepository{
    @Override
    public List<User> findAll() {
        return List.of();
    }
}
