package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String allUser(Model module){
        module.addAttribute("users",userService.getAllUsers());
        return "/users";
    }

    @GetMapping("/new")
    public String addNewUser(Model model){
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user){
        userService.createUser(user);
        return "redirect:/admins";
    }

    @GetMapping("/{id}/update")
    public String editUser(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/admins";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "redirect:/admins";
    }
}
