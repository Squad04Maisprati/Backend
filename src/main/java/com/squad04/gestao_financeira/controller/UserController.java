package com.squad04.gestao_financeira.controller;

import com.squad04.gestao_financeira.dto.;
import com.squad04.gestao_financeira.dto.;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.squad04.gestao_financeira.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import java.net.URI;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1/users")

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody CreateUserDto createUserDto) {
        var userId = userService.createUser(createUserDto);

        return ResponseEntity.created (URI.create ("/v1/users/" + userId.toString())).build();
    }

    @GetMapping("/userId")
    public ResponseEntity<User> getUserById(@PathVariable ("userId") String UserId) {
            var user = userService.getUserById(UserId);

            if (user.isPresent ()) {
                return ResponseEntity.ok(user.get());
            } else {
                return ResponseEntity.notFound().build();
            }
    }

    @GetMapping
    public ResponseEntity <List<User>> ListUsers () {
        var users = userService.listUsers ();

        return ResponseEntity.ok (users);
    }

    @PutMapping ("/{userId}")
    public ResponseEntity<Void> updateUserById (@PathVariable("userId") String userId, @RequestBody UpdateUserDto) {
        userService.updateUserById(userId, updateUserDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping ("/{userId}")
    public ResponseEntity<Void> deleteByID (@PathVariable("userID") String userId) {
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

}