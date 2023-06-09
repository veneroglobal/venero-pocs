package com.harjai.librarymanagementsystem.users.controller;


import com.harjai.librarymanagementsystem.users.dto.UserRequest;
import com.harjai.librarymanagementsystem.users.entity.User;
import com.harjai.librarymanagementsystem.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<?> fetchAllUser(){
        List<User> allUserList = this.userService.fetchUser();
        return ResponseEntity.ok(allUserList);
    }

    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody UserRequest userRequest){
        User savedUser = this.userService.saveUser(userRequest);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody UserRequest userRequest){
        User savedUser = this.userService.updateUser(userRequest);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> fetchUserById(@PathVariable Long id)throws Exception{
        User userById = this.userService.fetchUserById(id);
        return ResponseEntity.ok(userById);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) throws Exception{
        String message = this.userService.deleteUserById(id);
        return ResponseEntity.ok(message);
    }

}
