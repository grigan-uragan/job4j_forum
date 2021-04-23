package ru.grigan.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.grigan.job4j.forum.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
