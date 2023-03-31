package com.capstone.Inquizitive.database.dao;

import com.capstone.Inquizitive.database.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDAO extends JpaRepository<Team, Long> {

    Team findById(int id);
    Team findByTeamName(String teamName);
}
