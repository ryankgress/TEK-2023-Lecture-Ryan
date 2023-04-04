package com.capstone.Inquizitive.database.dao;

import com.capstone.Inquizitive.database.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TeamDAO extends JpaRepository<Team, Long> {

    Team findById(int id);
    Team findByTeamName(String teamName);

    @Query(value="select t.*, GROUP_CONCAT(u.username SEPARATOR ',') as 'team_members' " +
            "from teams t left join team_members tm on t.id = tm.team_id left join users u on u.id = tm.user_id " +
            "group by t.id ;", nativeQuery=true)
    List<Map<String,Object>> getAllTeamsAndMembers();     // Not sure if I should add a new class bean w/ user list

    @Query(value="SELECT * FROM teams", nativeQuery = true)
    List<Team> getAllTeams();
}
