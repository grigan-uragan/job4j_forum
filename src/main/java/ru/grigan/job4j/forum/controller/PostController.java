package ru.grigan.job4j.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.grigan.job4j.forum.model.Post;
import ru.grigan.job4j.forum.service.PostService;

import java.util.List;
import java.util.Set;

@Controller
public class PostController {
    @Autowired
    private PostService service;

    @GetMapping("/addPost")
    public String addPost(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "edit";
    }

    @PostMapping("/savePost")
    public String savePost(@ModelAttribute("post") Post post) {
        User user = (User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        post.setUser(service.findUserByUsername(user.getUsername()));
        service.savePost(post);
        return "redirect:/index";
    }

    @GetMapping("/updatePost")
    public String updatePost(@RequestParam("postId") int id, Model model) {
        Post postById = service.getPostById(id);
        model.addAttribute("post", postById);
        return "edit";
    }

    @GetMapping("/deletePost")
    public String deletePost(@RequestParam("postId") int id) {
        service.deletePostById(id);
        return "redirect:/";
    }

    @GetMapping("/topics")
    public String getAllTopic(Model model) {
        Set<String> topics = service.getAllTopics();
        model.addAttribute("topics", topics);
        return "topicList";
    }

    @GetMapping("/getTopic")
    public String getTopic(@RequestParam("topic") String topic, Model model) {
        List<Post> posts = service.getPostByTopic(topic);
        model.addAttribute("posts", posts);
        return "posts";
    }
}
