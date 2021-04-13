package ru.grigan.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.grigan.job4j.forum.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
