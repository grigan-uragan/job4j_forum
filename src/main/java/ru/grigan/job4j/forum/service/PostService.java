package ru.grigan.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.grigan.job4j.forum.model.Post;
import ru.grigan.job4j.forum.model.User;
import ru.grigan.job4j.forum.repository.PostDAO;
import ru.grigan.job4j.forum.repository.UserDAO;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostService {
    private PostDAO postDAO;
    private UserDAO userDAO;

    public PostService(PostDAO postDAO, UserDAO userDAO) {
        this.postDAO = postDAO;
        this.userDAO = userDAO;
        init();
    }

    private void init() {
        User user = User.of("user", "qwerty");
        Post post = Post.of("what about BMW", "Simple talk about BMW");
        user.addPost(post);
        post.setUser(user);
        postDAO.save(post);
        userDAO.save(user);
    }

    public List<Post> allPosts() {
        return postDAO.getAll();
    }

    public void savePost(Post post) {
        postDAO.save(post);
    }

    public Post getPostById(int id) {
        return postDAO.findById(id);
    }

    public User findUserByUsername(String username) {
        return userDAO.findByName(username);
    }

    public void deletePostById(int id) {
        postDAO.deleteById(id);
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
