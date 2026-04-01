package io.mihaijulien.user.infrastructure;

import io.mihaijulien.user.domain.User;
import io.mihaijulien.user.domain.spi.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateUserRepository implements UserRepository {

        private final HibernateUserManager hibernateUserManager;

    public HibernateUserRepository(HibernateUserManager hibernateUserManager) {
        this.hibernateUserManager = hibernateUserManager;
    }

    @Override
    public List<User> findAll() {
        return hibernateUserManager.findAll().stream().map(userEntity -> new User(userEntity.getFirstName(),
                userEntity.getLastName())).toList();
    }

    @Override
    public void create(User user) {
        UserEntity userEntity = new UserEntity(user.firstName(), user.lastName());
        hibernateUserManager.save(userEntity);
    }
}
