package ru.grigan.job4j_forum.service;

import org.springframework.stereotype.Service;
import ru.grigan.job4j_forum.model.Post;
import ru.grigan.job4j_forum.model.User;
import ru.grigan.job4j_forum.repository.PostDAO;
import ru.grigan.job4j_forum.repository.UserDAO;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

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

    public List<Post>allPosts() {
        return postDAO.getAll();
    }





}
