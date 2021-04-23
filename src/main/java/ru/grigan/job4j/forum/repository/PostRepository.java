package ru.grigan.job4j.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.grigan.job4j.forum.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
