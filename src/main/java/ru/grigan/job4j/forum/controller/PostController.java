package ru.grigan.job4j.forum.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.grigan.job4j.forum.model.Post;
import ru.grigan.job4j.forum.model.User;
import ru.grigan.job4j.forum.service.PostService;
import ru.grigan.job4j.forum.service.UserService;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

@Controller
public class PostController {
    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/addPost")
    public String addPost(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        model.addAttribute("title", "Edit post");
        return "edit";
    }

    @PostMapping("/savePost")
    public String savePost(@ModelAttribute("post") Post post) {
        User user = (User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        post.setUser(userService.findUserByUsername(user.getUsername()));
        post.setCreated(Calendar.getInstance());
        postService.savePost(post);
        return "redirect:/index";
    }

    @GetMapping("/updatePost/{postId}")
    public String updatePost(@PathVariable("postId") int id, Model model) {
        Post postById = postService.getPostById(id);
        model.addAttribute("post", postById);
        model.addAttribute("title", "Edit post");
        return "edit";
    }

    @GetMapping("/deletePost/{postId}")
    public String deletePost(@PathVariable("postId") int id) {
        postService.deletePostById(id);
        return "redirect:/";
    }

    @GetMapping("/topics")
    public String getAllTopic(Model model) {
        Set<String> topics = postService.getAllTopics();
        model.addAttribute("topics", topics);
        model.addAttribute("title", "Topics");
        return "topicList";
    }

    @GetMapping("/getTopic/{topic}")
    public String getTopic(@PathVariable("topic") String topic, Model model) {
        List<Post> posts = postService.getPostByTopic(topic);
        model.addAttribute("posts", posts);
        model.addAttribute("title", "Posts");
        return "posts";
    }
}
