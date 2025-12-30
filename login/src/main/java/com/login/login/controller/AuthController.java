package com.login.login.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.login.login.entity.User;
import com.login.login.repository.UserRepository;

import java.security.Principal;
import java.util.List;

@Controller
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Show signup page
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    // Handle signup form
    @PostMapping("/signup")
    public String signup(User user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        userRepository.save(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Principal principal, Model model) {

        String username = principal.getName(); // email
        model.addAttribute("username", username);

        return "loginSuccess";
    }









































//
//    @Autowired
//    private UserRepository repo;
//
//
//
//
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @GetMapping("/home")
//    public String home() {
//        return "home";
//    }






















//
//    // Signup page
//    @GetMapping("/signup")
//    public String signupPage() {
//        return "signup";
//    }
//
//    @PostMapping("/signup")
//    public String signup(User user) {
//        repo.save(user);
//        return "redirect:/login";
//    }
//
//    // Login page
//    @GetMapping("/login")
//    public String loginPage() {
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam String email,
//                        @RequestParam String password,
//                        Model model,
//                        HttpSession session) {
//
//        User user = repo.findByEmail(email);
//
//        if (user != null && user.getPassword().equals(password)) {
//            session.setAttribute("user_name", user.getName());
//            session.setAttribute("user_id", user.getId());
//            model.addAttribute("name", user.getName());
//            return "welcome";
//        }
//        model.addAttribute("error", "Invalid Credentials");
//        return "login";
//    }
//
//    @GetMapping("/users")
//    public String listUsers(Model model) {
//        // Fetch all users from the database
//        List<User> users = repo.findAll();
//        // Add the list to the model so the view can access it
//        model.addAttribute("users", users);
//
//        // Return the view name
//        return "users";
//    }

}
















































//    @GetMapping("/userlist")
//    public String profile(HttpSession session, Model model) {
//        User user = (User) session.getAttribute("user");
//
//        String userName = (String) session.getAttribute("user_name");
//        Long userId = (Long) session.getAttribute("user_id");
//
//
//
//        if (userName == null) {
//            return "redirect:/login"; // no user in session
//        }else{
//
//
//        List<User> users = repo.findAll();
//        model.addAttribute("users", users);
//        return "users";
//        }
//        }