package com.harjai.librarymanagementsystem.users.service;


import com.harjai.librarymanagementsystem.users.dto.UserRequest;
import com.harjai.librarymanagementsystem.users.entity.User;
import com.harjai.librarymanagementsystem.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> fetchUser()
    {
        return (List<User>) this.userRepository.findAll();
    }

    public User saveUser(UserRequest userRequest){

        User user = new User();
        user.setId(userRequest.getId());
        user.setName(userRequest.getName());
        user.setRole(userRequest.getRole());
        user.setCreatedDate(new Date());

        User savedUser = this.userRepository.save(user);
        return savedUser;
    }

    public User updateUser(UserRequest userRequest){
        Optional<User> existingUser = this.userRepository.findById(userRequest.getId());
        User user = null;
        if(existingUser.isPresent()){
            user = existingUser.get();
            user.setName(userRequest.getName());
            user.setRole(userRequest.getRole());
            this.userRepository.save(user);
        }
        return user;
    }

    public User fetchUserById(Long id)throws Exception{
        Optional<User> user = this.userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }throw new Exception("User Not Found");
    }

    public String deleteUserById(Long id) throws Exception{
        try{
            this.userRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception("User not found in the system ....");
        }
        return "User Successfully Removed..";
    }
}
