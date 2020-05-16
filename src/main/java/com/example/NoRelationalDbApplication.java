package com.example;

import com.example.assignment.Assignment;
import com.example.champion.Champion;
import com.example.repository.AssignmentRepository;
import com.example.repository.ChampionRepository;
import com.example.repository.PlayerRepository;
import com.example.repository.TeamRepository;
import com.example.role.Role;
import com.example.team.Team;
import com.example.player.Player;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class NoRelationalDbApplication implements CommandLineRunner {
    private PlayerRepository playerRepository;
    private ChampionRepository championRepository;
    private TeamRepository teamRepository;
    private AssignmentRepository assignmentRepository;

    @Autowired
    public NoRelationalDbApplication(PlayerRepository playerRepository, ChampionRepository championRepository, TeamRepository teamRepository, AssignmentRepository assignmentRepository) {
        this.playerRepository = playerRepository;
        this.championRepository = championRepository;
        this.teamRepository = teamRepository;
        this.assignmentRepository = assignmentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(NoRelationalDbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //CHAMPION SETUP
        this.championRepository.deleteAll();
        Champion ch1 = new Champion(ObjectId.get(), "Champion-Test1");
        Champion ch2 = new Champion(ObjectId.get(), "Champion-Test2");
        Champion ch3 = new Champion(ObjectId.get(), "Champion-Test3");
        Champion ch4 = new Champion(ObjectId.get(), "Champion-Test4");
        Champion ch5 = new Champion(ObjectId.get(), "Champion-Test5");
        List<Champion> champions = List.of(ch1, ch2, ch3, ch4, ch5);
        this.championRepository.saveAll(champions);

        //USERS SETUP
        this.playerRepository.deleteAll();
        Player p1 = new Player(ObjectId.get(), "User-Name-Test1", "User-LastName-Test1", "User-Nick-Test1", true, Role.MID, Collections.emptyList(), Set.of(ch1, ch2), Collections.emptyList(), null);
//        Player u2 = new Player(ObjectId.get(), "User-Test2", "User-Test2", Role.TEST, Set.of(ch2, ch4));
//        Player u3 = new Player(ObjectId.get(), "User-Test3", "User-Test3", Role.TEST, Set.of(ch3, ch5));
//        Player u4 = new Player(ObjectId.get(), "User-Test4", "User-Test4", Role.TEST, Set.of(ch5));
//        Player u5 = new Player(ObjectId.get(), "User-Test5", "User-Test5", Role.TEST, Set.of(ch1, ch5));
        List<Player> players = List.of(p1);
        this.playerRepository.saveAll(players);

        //TEAMS SETUP
        this.teamRepository.deleteAll();
        Team t1 = new Team(ObjectId.get(), "Team-Name1");
        List<Team> teams = List.of(t1);
        this.teamRepository.saveAll(teams);
//
//        P1 & P2 + team
//        this.playerRepository.delete(p1);
        p1.setCurrentTeam(t1);
        Player p2 = new Player(ObjectId.get(), "User-Name-Test2", "User-LastName-Test2", "User-Nick-Test2", true, Role.TOP, List.of(Role.MID, Role.BOT), Set.of(ch1, ch3, ch4), Collections.emptyList(), t1);
        this.playerRepository.saveAll(List.of(p1, p2));

        //Assignment SETUP
        this.assignmentRepository.deleteAll();
        Assignment assignment = new Assignment(ObjectId.get(), p1, t1, LocalDate.of(2015, 8, 1), LocalDate.of(2016, 10, 10));
        this.assignmentRepository.save(assignment);

        t1.setAssignments(List.of(assignment));
        this.teamRepository.delete(t1);
        this.teamRepository.save(t1);

        p1.setAssignments(List.of(assignment));
        this.playerRepository.delete(p1);
        this.playerRepository.save(p1);
    }
}
