package com.io.rj.userapi.controller;

import com.io.rj.userapi.Entity.User;
import com.io.rj.userapi.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/auth")

public class AuthenticationController {
    @Autowired
    IUser userService;

    @PostMapping("/registerUser")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.ok().body(newUser);
    }

    @GetMapping("/displayUser")
    public ResponseEntity <Object> displayUser() {
        List<User> existingUsers = userService.listUsers();
        return ResponseEntity.ok().body(existingUsers);
    }

    @PutMapping("updateUser/{id}")
    public ResponseEntity <Object> updateUser(@RequestBody User user, @PathVariable Long id) {
        User editUser = userService.updateUser(user, id);
        return ResponseEntity.ok().body(editUser);
    }

    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity <String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().body("Successfully Deleted");
    }

//    @PostMapping("/login")
//    public ResponseEntity <Object> login(@Valid @RequestBody String name, String password ){
//        userService.login(name, password);
////        if(StringUtils.isEmpty(token)){
////            return "no token found";
////        }
////        return token;
//        return ResponseEntity.ok().body("Logged in" + token);
//    }
}
