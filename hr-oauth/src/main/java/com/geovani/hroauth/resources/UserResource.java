package com.geovani.hroauth.resources;

import com.geovani.hroauth.entities.User;
import com.geovani.hroauth.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/search")
    private ResponseEntity<User> findByEmail(@RequestParam String email) {

        User user = userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}
