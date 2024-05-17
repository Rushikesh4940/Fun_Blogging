package com.example.Fun_Blogging.repository;

import com.example.Fun_Blogging.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
