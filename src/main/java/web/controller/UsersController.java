package web.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;


@Controller

public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String showAllUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users/allusers";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        model.addAttribute("user",userService.getUser(id));
        return "users/showuser";
    }
    @GetMapping("/newuser")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "users/newuser";
    }
    @PostMapping("/adduser")
    public String addUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/deleteUser{id}")
    public String deleteUser(@RequestParam(value = "id") Long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }


    @PatchMapping("/update{id}")
    public String update(@ModelAttribute User user){
        userService.updateUser(user);
        return "redirect:/";
    }
}