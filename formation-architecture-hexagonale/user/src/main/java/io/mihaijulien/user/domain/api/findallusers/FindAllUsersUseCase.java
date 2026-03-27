package io.mihaijulien.user.domain.api.findallusers;

import io.mihaijulien.user.domain.User;

import java.util.List;

public interface FindAllUsersUseCase {
    List<User> findAll();
}
