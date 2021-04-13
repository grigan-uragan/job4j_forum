package ru.grigan.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.grigan.job4j.forum.model.Post;
import ru.grigan.job4j.forum.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> allPosts() {
        List<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);
        return posts;
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public Post getPostById(int id) {
        return postRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Post with id = " + id + " not found")
        );
    }

    public void deletePostById(int id) {
        postRepository.deleteById(id);
    }

    public Set<String> getAllTopics() {
        return allPosts()
                .stream()
                .map(Post::getTopic)
                .collect(Collectors.toSet());
    }

    public List<Post> getPostByTopic(String topic) {
        return allPosts()
                .stream()
                .filter(post -> post.getTopic().equals(topic))
                .collect(Collectors.toList());
    }
}
