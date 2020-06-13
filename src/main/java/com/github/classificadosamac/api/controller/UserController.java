package com.github.classificadosamac.api.controller;

import com.github.classificadosamac.api.model.User;
import com.github.classificadosamac.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> userSave(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> userUpdate(@RequestBody User user, @PathVariable Long id) {
        return ResponseEntity.ok(userService.update(user, id));
    }

}
