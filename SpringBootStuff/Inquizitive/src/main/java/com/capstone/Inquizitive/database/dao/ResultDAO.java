package com.capstone.Inquizitive.database.dao;

import com.capstone.Inquizitive.database.entity.Result;
import com.capstone.Inquizitive.database.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultDAO extends JpaRepository<Result, Long> {
    Result findById(int id);
}
