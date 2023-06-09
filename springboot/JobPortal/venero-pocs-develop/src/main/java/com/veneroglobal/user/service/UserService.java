package com.veneroglobal.user.service;

import com.veneroglobal.common.dto.UserRequest;
import com.veneroglobal.common.entity.User;
import com.veneroglobal.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest userRequest) {
        User user = new User();

        user.setName(userRequest.getName());
        user.setEmailId(userRequest.getEmailId());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setAge(userRequest.getAge());
        user.setLocation(userRequest.getLocation());
        user.setQualification(user.getQualification());
        user.setMembershipType(userRequest.getMembershipType());

        User saveUser = this.userRepository.save(user);
        return user;

    }

    public List<User> fetchAllUser() {
        return (List<User>) this.userRepository.findAll();
    }

    public User fetchUserById(Integer id)throws Exception {
        Optional<User> user = this.userRepository.findById(id);
        if(user.isPresent()){
            return user.get();

        }
        throw new Exception("User not found");
    }

    public String deleteUserById(Integer id) {
        return "Deleted Succesfully";
    }
}

