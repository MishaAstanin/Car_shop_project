package com.example.cardbproject.controllers;


import com.example.cardbproject.entities.User;
import com.example.cardbproject.security.MyUserDetails;
import com.example.cardbproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") User user)
    {
        userService.addUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getRegistration(Model model)
    {
        model.addAttribute("user", new User());
        return "authorization";
    }

    @GetMapping("/account")
    public String getAccount(Model model , @AuthenticationPrincipal MyUserDetails myUserDetails)
    {
        int id = myUserDetails.getUser().getId();
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "account";
    }
}
