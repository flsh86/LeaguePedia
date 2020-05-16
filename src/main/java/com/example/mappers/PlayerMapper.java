package com.example.mappers;

import com.example.assignment.Assignment;
import com.example.champion.Champion;
import com.example.champion.ChampionDTO;
import com.example.role.Role;
import com.example.team.Team;
import com.example.team.TeamDTO;
import com.example.player.Player;
import com.example.player.PlayerDTO;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.mappers.validators.Validators.*;

public class PlayerMapper {
    public static Player toEntity(PlayerDTO dto) {
        //Mapping user's champions
        Set<Champion> champions;
        if(dto.getChampions() == null || dto.getChampions().isEmpty()) {
            champions = Collections.emptySet();
        } else {
            champions = dto.getChampions()
                    .stream()
                    .map(ChampionMapper::toEntity)
                    .collect(Collectors.toSet());
        }

        List<Role> previousRoles;
        if(dto.getPreviousRole() == null || dto.getPreviousRole().isEmpty()) {
            previousRoles = Collections.emptyList();
        } else {
            previousRoles = dto.getPreviousRole()
                    .stream()
                    .map(Role::valueOf)
                    .collect(Collectors.toList());
        }

//        List<Team> previousTeams;
//        if(dto.getPreviousTeams() == null || dto.getPreviousTeams().isEmpty()) {
//            previousTeams = Collections.emptyList();
//        } else {
//            previousTeams = dto.getPreviousTeams()
//                    .stream()
//                    .map(TeamMapper::toEntity)
//                    .collect(Collectors.toList());
//        }

        Team currentTeam = new Team();
        if(dto.getCurrentTeam() != null) {
            currentTeam = TeamMapper.toEntity(dto.getCurrentTeam());
        }

        return new Player(
                validId(dto.getId()), //OK
                dto.getFirstName(), //OK
                dto.getLastName(), //OK
                dto.getNick(), //OK
                dto.getStatus(),
                validRole(dto.getRole()), //OK
                previousRoles, //OK
                champions, //OK
//                previousTeams, //CHANGE!
                currentTeam
        );
    }

    public static PlayerDTO toDTO(Player entity) {
        Set<ChampionDTO> champions;
        if(entity.getChampions().isEmpty()) {
            champions = Collections.emptySet();
        } else {
            champions = entity.getChampions()
                    .stream()
                    .map(ChampionMapper::toDTO)
                    .collect(Collectors.toSet());
        }

        List<String> previousRoles;
        if(entity.getPreviousRoles() == null || entity.getPreviousRoles().isEmpty()) {
            previousRoles = Collections.emptyList();
        } else {
            previousRoles = entity.getPreviousRoles()
                    .stream()
                    .map(Role::toString)
                    .collect(Collectors.toList());
        }

        TeamDTO currentTeam = new TeamDTO();
        if(entity.getCurrentTeam() != null) {
            currentTeam = TeamMapper.toDTO(entity.getCurrentTeam());
        }

        List<Assignment> assignments = entity.getAssignments();
        assignments.forEach(System.out::println);

        return new PlayerDTO(
                entity.get_id().toString(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getNick(),
                entity.getStatus(),
                entity.getRole().toString(),
                previousRoles,
                champions,
                currentTeam
        );
    }

}
