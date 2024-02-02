package com.example.neww.controllers;

import com.example.neww.model.LoginProcessor;
import com.example.neww.services.LoginSaver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.neww.model.User;
import com.example.neww.repositories.UserRepository;


import java.util.List;
@Controller
public class MainController {

    private final LoginProcessor loginProcessor;
    private final LoginSaver loginSaver;
    private final UserRepository userRepository;

    public MainController(LoginProcessor loginProcessor, LoginSaver loginSaver,
                          UserRepository userRepository) {
        this.loginProcessor = loginProcessor;
        this.loginSaver = loginSaver;
        this.userRepository = userRepository;
    }
    @GetMapping("/index")
    public String index() {
        return "index.html";
    }

    @GetMapping("/authorization")
    public String authorization() {
        return "authorization.html";
    }

    @GetMapping("/event")
    public String event(
            @RequestParam(required = false) String title,
            Model page) {
        page.addAttribute("eventtitle", title);
        return "event.html";
    }

    @PostMapping("/authorization")
    public String login( @RequestParam String username, @RequestParam String password, Model model ) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        String post = loginProcessor.login();
        switch (post) {
            case "organizer":
                return "organizer.html";
            case "participant":
                return "participant.html";
            case "moderator":
                return "moderator.html";
            case "jury":
                return "jury.html";
        }

        model.addAttribute("message", "Login failed!");
        return "authorization.html";
    }

    @GetMapping("/moderator")
    public String moderator(@RequestParam(required = false) String logout) {
        if (logout != null)
        {
            loginSaver.setUsername(null);
        }
        if (loginSaver.getUsername() != null && loginSaver.getUsername().equals("Moder")) {
                return "moderator.html";
        }
        return "redirect:/authorization";
    }

    @GetMapping("/organizer")
    public String organizer(@RequestParam(required = false) String logout) {
        if (logout != null)
        {
            loginSaver.setUsername(null);
        }
        if (loginSaver.getUsername() != null && loginSaver.getUsername().equals("Org")) {
            return "organizer.html";
        }
        return "redirect:/authorization";
    }

    @GetMapping("/participant")
    public String participant(@RequestParam(required = false) String logout) {
        if (logout != null)
        {
            loginSaver.setUsername(null);
        }
        if (loginSaver.getUsername() != null && loginSaver.getUsername().equals("Par")) {
            return "participant.html";
        }
        return "redirect:/authorization";
    }

    @GetMapping("/jury")
    public String jury(@RequestParam(required = false) String logout) {
        if (logout != null)
        {
            loginSaver.setUsername(null);
        }
        if (loginSaver.getUsername() != null && loginSaver.getUsername().equals("Jury")) {
            return "jury.html";
        }
        return "redirect:/authorization";
    }

    @PostMapping("/user")
    @ResponseBody
    public void storeUser(@RequestBody User user) {
        userRepository.storeUser(user);
    }

    @GetMapping("/user")
    @ResponseBody
    public List<User> findUsers(){
        return userRepository.findAllUsers();
    }
}
