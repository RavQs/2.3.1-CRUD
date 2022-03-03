package com.example.alishevcrud.controllers;


import com.example.alishevcrud.model.User;
import com.example.alishevcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        //Получим всех юзеров из DAO и передадим отображение в представление
        model.addAttribute("users", userService.index());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //Получим одного человека по его Id из DAO и передадим на отображение в представление
        model.addAttribute("user", userService.showUserById(id));
        return "users/user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {     //BindingResult необходим для отображения ошибок
        if(bindingResult.hasErrors())
            return "users/new";
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.showUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user")@Valid User user,
                         BindingResult bindingResult,@PathVariable("id") long id){
        if(bindingResult.hasErrors())
            return "users/edit";

        userService.update(id,user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        userService.delete(id);
        return "redirect:/users";
    }

}
