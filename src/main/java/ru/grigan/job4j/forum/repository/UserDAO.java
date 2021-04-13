package ru.grigan.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.grigan.job4j.forum.model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDAO implements DAO<User> {
    private final Map<Integer, User> users = new HashMap<>();
    private final AtomicInteger ids = new AtomicInteger();

    @Override
    public void save(User element) {
        if (element.getId() == 0) {
            element.setId(ids.incrementAndGet());
            users.put(element.getId(), element);
        } else {
            users.computeIfPresent(element.getId(), (a, b) -> b = element);
        }
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User findById(int id) {
        return users.get(id);
    }

    @Override
    public void deleteById(int id) {
        users.remove(id);
    }

    public User findByName(String username) {
        for (User user : users.values()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new NoSuchElementException("User with username : " + username + " not found!");
    }
}
