package com.harjai.librarymanagementsystem.users.repository;


import com.harjai.librarymanagementsystem.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
