package com.example.authApp.controller;

import com.example.authApp.entity.User;
import com.example.authApp.service.UserService;
import com.example.authApp.util.RegistrationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;
    @PostMapping("/register")
    public List<RegistrationMessage> register(@RequestBody User user){
        return service.register(user);
    }

    @PostMapping("/login")
    public List login(@RequestBody User user){
        return  service.login(user);

    }

   /* @PostMapping("/update")
    public String update(@RequestBody User user){
        return  service.update(user);

    }*/
    /*
    @PostMapping("/delete")
    public String delete(@RequestBody User user){
        return  service.delete(user);

    }*/

    @PostMapping("/all_users")
    public List<User> all_users(){
        return  service.all_users();

    }

    @GetMapping("/demo")
    public String demo(){
        return "this is for testing";
    }
}
