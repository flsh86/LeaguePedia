package com.example.player;

import com.example.assignment.Assignment;
import com.example.champion.Champion;
import com.example.role.Role;
import com.example.team.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class Player {
    @Id
    private ObjectId _id;
    private String firstName;
    private String lastName;
    private String nick;
    private Boolean status;
    private Role role;
    private List<Role> previousRoles = new ArrayList<>();
    private Set<Champion> champions = new HashSet<>();
    //    @DBRef(lazy = true)
    //    private List<Team> previousTeams;
    private List<Assignment> assignments;
    private Team currentTeam;

    public Player(ObjectId _id, String firstName, String lastName, String nick, Boolean status, Role role, List<Role> previousRoles, Set<Champion> champions, Team currentTeam) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nick = nick;
        this.status = status;
        this.role = role;
        this.previousRoles = previousRoles;
        this.champions = champions;
        this.currentTeam = currentTeam;
    }

//    @PersistenceConstructor
//    public User(ObjectId _id, String firstName, String lastName) {
//        this._id = _id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }

}
