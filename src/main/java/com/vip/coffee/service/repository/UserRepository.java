package com.vip.coffee.service.repository;

import com.vip.coffee.service.enums.UserRole;
import com.vip.coffee.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameOrEmail(String username, String email);

    default Optional<User> findByLogin(String login) {
        return this.findByUsernameOrEmail(login, login);
    }

    List<User> findAllByRolesContains(UserRole role);

    default List<User> findAllMasters() {
        return findAllByRolesContains(UserRole.MASTER);
    }

    Optional<User> findByUsername(String username);
}
