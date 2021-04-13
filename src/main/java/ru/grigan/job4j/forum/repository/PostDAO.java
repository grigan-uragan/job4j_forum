package ru.grigan.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.grigan.job4j.forum.model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostDAO implements DAO<Post> {
    private final Map<Integer, Post> posts = new HashMap<>();
    private final AtomicInteger ids = new AtomicInteger();

    @Override
    public void save(Post element) {
        if (element.getId() == 0) {
            element.setId(ids.incrementAndGet());
            posts.put(element.getId(), element);
        } else {
            posts.computeIfPresent(element.getId(), (a, b) -> b = element);
        }
    }

    @Override
    public List<Post> getAll() {
        return new ArrayList<>(posts.values());
    }

    @Override
    public Post findById(int id) {
        return posts.get(id);
    }

    @Override
    public void deleteById(int id) {
        posts.remove(id);
    }
}
