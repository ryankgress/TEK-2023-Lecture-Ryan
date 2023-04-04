package com.capstone.Inquizitive.database.dao;

import com.capstone.Inquizitive.database.entity.Team;
import com.capstone.Inquizitive.database.entity.TeamMember;
import com.capstone.Inquizitive.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamMemberDAO extends JpaRepository<TeamMember, Long> {
    TeamMember findById(int id);

    @Query("SELECT u FROM User u, TeamMember tm, Team t " +
            "WHERE u.id = tm.userId AND tm.teamId = t.id AND t.teamName = :teamName ")
    List<User> getUsersByTeamName(String teamName);
}
