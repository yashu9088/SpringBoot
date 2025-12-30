package com.login.login.controller;

import com.login.login.entity.KeyPoint;
import com.login.login.entity.User;
import com.login.login.repository.KeyPointRepository;
import com.login.login.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class KeyPointController {

    private final KeyPointRepository keyPointRepository;
    private final UserRepository userRepository;

    public KeyPointController(KeyPointRepository keyPointRepository,
                              UserRepository userRepository) {
        this.keyPointRepository = keyPointRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/add-keypoint")
    public String addKeyPointPage() {
        return "add-keypoint";
    }

    @PostMapping("/add-keypoint")
    public String saveKeyPoint(@RequestParam("points") String points,
                               Principal principal) {

        // Logged-in user's email
        String email = principal.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        KeyPoint kp = new KeyPoint(user, points);
        keyPointRepository.save(kp);

        return "redirect:/my-keypoints";
    }

    @GetMapping("/my-keypoints")
    public String myKeyPoints(Model model, Principal principal) {

        String email = principal.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        model.addAttribute(
                "keypoints",
                keyPointRepository.findByUser(user)
        );

        return "my-keypoints";
    }
}
