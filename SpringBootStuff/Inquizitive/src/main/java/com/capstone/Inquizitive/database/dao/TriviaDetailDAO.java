package com.capstone.Inquizitive.database.dao;

import com.capstone.Inquizitive.database.entity.Team;
import com.capstone.Inquizitive.database.entity.TriviaDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TriviaDetailDAO extends JpaRepository<TriviaDetail, Long> {
    TriviaDetail findById(int id);

    @Query(value="SELECT * FROM trivia_details order by date_time;", nativeQuery = true)
    List<TriviaDetail> getAllRecords();


}
