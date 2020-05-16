package com.example.player;

import com.example.champion.ChampionDTO;
import com.example.team.TeamDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlayerDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String nick;
    private Boolean status;
    private String role;
    private List<String> previousRole = new ArrayList<>();
    private Set<ChampionDTO> champions = new HashSet<>();
    private TeamDTO currentTeam;
}
