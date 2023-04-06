package com.capstone.Inquizitive.database.dao;

import com.capstone.Inquizitive.database.entity.Team;
import com.capstone.Inquizitive.database.entity.TeamMember;
import com.capstone.Inquizitive.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TeamMemberDAO extends JpaRepository<TeamMember, Long> {
    @Query("SELECT tm FROM TeamMember tm WHERE tm.id = :id ")
    TeamMember findById(int id);

    @Query("SELECT u FROM User u, TeamMember tm, Team t " +
            "WHERE u.id = tm.userId AND tm.teamId = t.id AND t.teamName = :teamName ")
    List<User> getUsersByTeamName(String teamName);

    /**
     * Want to return name, username, email, profilePic, sum(points) etc etc, team(team1,team2,team3,team4)?
     * @param id
     * @return
     */
    @Query(value =
            "SELECT u.id, u.username, u.email, u.profile_pic, u.name, GROUP_CONCAT(t.team_name SEPARATOR ',') AS " +
                "team_list, SUM(t.total_score) AS user_total " +
            "FROM users u LEFT JOIN team_members tm ON u.id = tm.user_id LEFT JOIN teams t ON t.id = tm.team_id " +
            "WHERE u.id = :id " +
            "GROUP BY u.id ;", nativeQuery = true)
    Map<String, Object> getProfileInfo(Integer id);
}
