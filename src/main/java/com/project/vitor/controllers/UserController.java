package com.project.vitor.controllers;

import com.project.vitor.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Vitor", "vitormwxm@gmail.com", "81983132387", "123456");
        return ResponseEntity.ok().body(user);
    }
}
