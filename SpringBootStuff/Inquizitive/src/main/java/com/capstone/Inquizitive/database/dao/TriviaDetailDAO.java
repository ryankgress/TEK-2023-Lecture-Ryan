package com.capstone.Inquizitive.database.dao;

import com.capstone.Inquizitive.database.entity.Team;
import com.capstone.Inquizitive.database.entity.TriviaDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriviaDetailDAO extends JpaRepository<TriviaDetail, Long> {
    TriviaDetail findById(int id);


}
