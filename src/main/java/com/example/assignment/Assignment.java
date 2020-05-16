package com.example.assignment;

import com.example.team.Team;
import com.example.player.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "player_teams")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Assignment {
    @Id
    ObjectId objectId;
    @DBRef(lazy = true)
    private Player player;
    @DBRef(lazy = true)
    private Team team;
    private LocalDate start;
    private LocalDate end;
}
