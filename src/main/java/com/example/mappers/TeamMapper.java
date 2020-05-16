package com.example.mappers;

import com.example.team.Team;
import com.example.team.TeamDTO;
import org.bson.types.ObjectId;

public class TeamMapper {
    public static Team toEntity(TeamDTO dto) {
//        List<Player> members = dto.getMembers().stream()
//                .map(PlayerMapper::toEntity)
//                .collect(Collectors.toList());

        ObjectId id;
        if(dto.getId() == null || dto.getId().isEmpty()) {
            id = new ObjectId();
        } else {
            try {
                id = new ObjectId(dto.getId());
            } catch (IllegalArgumentException e) {
                id = new ObjectId();
            }
        }

        return new Team(
                id,
                dto.getName()
//                dto.getName(),
//                members
        );
    }

    public static TeamDTO toDTO(Team entity) {
//        List<PlayerDTO> members = entity.getMembers().stream()
//                .map(PlayerMapper::toDTO)
//                .collect(Collectors.toList());

        return new TeamDTO(
                entity.getId().toString(),
                entity.getName()
//                entity.getName(),
//                members
        );
    }
}
