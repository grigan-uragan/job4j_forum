package ru.grigan.job4j.forum.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.grigan.job4j.forum.model.User;
import ru.grigan.job4j.forum.service.UserService;

@Controller
public class RegController {
    private final PasswordEncoder encoder;
    private final UserService userService;

    public RegController(PasswordEncoder encoder, UserService userService) {
        this.encoder = encoder;
        this.userService = userService;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String registration(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "reg";
    }
}
