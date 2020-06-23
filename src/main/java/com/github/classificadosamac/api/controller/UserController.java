package com.github.classificadosamac.api.controller;

import com.github.classificadosamac.api.dto.UserDTO;
import com.github.classificadosamac.api.model.User;
import com.github.classificadosamac.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping
    @ResponseBody
    public List<UserDTO> list() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserDTO>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id) {
        return ResponseEntity.ok(userService.update(user, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok(null);
    }

}
