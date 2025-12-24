package com.login.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.login.login.entity.User;
import com.login.login.repository.UserRepository;

@Controller
public class AuthController {

    @Autowired
    private UserRepository repo;

    // Signup page
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(User user) {
        repo.save(user);
        return "redirect:/login";
    }

    // Login page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model) {

        User user = repo.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("name", user.getName());
            return "welcome";
        }

        model.addAttribute("error", "Invalid Credentials");
        return "login";
    }
}
