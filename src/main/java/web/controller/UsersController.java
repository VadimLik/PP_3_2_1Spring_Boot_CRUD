package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UsersServise;


@Controller
@RequestMapping("/")
public class UsersController {

    final UsersServise usersService;

    @Autowired
    public UsersController(UsersServise userService) {
        this.usersService = userService;

    }

    @GetMapping
    public String getUsers( Model model) {

        model.addAttribute("userlist", usersService.getAllUsers());

        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {

        model.addAttribute("user", new User());

        return "new";
    }

    @GetMapping("/update{id}")
    public String update(@RequestParam("id") long id, Model model) {

        model.addAttribute("user", usersService.getUser(id));

        return "edit";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {

        usersService.saveUser(user);

        return "redirect:/";

    }

    @PostMapping("/{id}")
    public String deleteUser(@RequestParam("id") long id) {

        usersService.deleteUser(id);

        return "redirect:/";
    }

    @PostMapping("/update{id}")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam("id") long id) {

        usersService.updateUser(user, id);

        return "redirect:/";
    }
}
