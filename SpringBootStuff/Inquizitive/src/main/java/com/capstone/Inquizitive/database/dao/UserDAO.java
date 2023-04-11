package com.capstone.Inquizitive.database.dao;

import com.capstone.Inquizitive.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDAO extends JpaRepository<User, Long> {

    User findById(int id);

    User findByUsername(String username);



}
