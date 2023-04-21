package com.capstone.Inquizitive.database.dao;

import com.capstone.Inquizitive.database.entity.Result;
import com.capstone.Inquizitive.database.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ResultDAO extends JpaRepository<Result, Long> {
    Result findById(int id);

    @Query(value =
            "SELECT t.* FROM results r JOIN teams t ON(t.id = r.team_id) " +
            "WHERE r.trivia_id = :triviaId ;", nativeQuery = true)
    List<Map<String,Object>> getTeamsByTriviaId(Integer triviaId);
}
