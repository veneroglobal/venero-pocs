package com.veneroglobal.user.controller;

import com.veneroglobal.common.dto.UserRequest;
import com.veneroglobal.common.entity.User;
import com.veneroglobal.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

        @PostMapping("/users")
    public ResponseEntity<?> saveUser(@RequestBody UserRequest userRequest){
            this.userService.saveUser(userRequest);
            return ResponseEntity.ok(userRequest);
        }

        @GetMapping("/users")
    public ResponseEntity<?> fetchAllUser(){
            List<User> allUserlist = this.userService.fetchAllUser();
            return ResponseEntity.ok(allUserlist);
        }

        @GetMapping("/users/{id}")
    public ResponseEntity<?> fetchUserById(@PathVariable Integer id) throws Exception{
            User userById = this.userService.fetchUserById(id);
            return ResponseEntity.ok(userById);

    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Integer id) throws Exception {
        String message = this.userService.deleteUserById(id);
        return ResponseEntity.ok(message);
    }

}
