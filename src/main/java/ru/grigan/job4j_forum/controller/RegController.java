package ru.grigan.job4j_forum.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.grigan.job4j_forum.model.User;
import ru.grigan.job4j_forum.repository.UserDAO;

@Controller
public class RegController {
    private final PasswordEncoder encoder;
    private final UserDAO userDAO;

    public RegController(PasswordEncoder encoder, UserDAO userDAO) {
        this.encoder = encoder;
        this.userDAO = userDAO;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userDAO.save(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String registration(@ModelAttribute User user) {
        return "reg";
    }
}
