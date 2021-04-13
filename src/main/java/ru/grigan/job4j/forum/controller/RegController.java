package ru.grigan.job4j.forum.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.grigan.job4j.forum.model.User;
import ru.grigan.job4j.forum.repository.UserRepository;

@Controller
public class RegController {
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    public RegController(PasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String registration(@ModelAttribute User user) {
        return "reg";
    }
}
