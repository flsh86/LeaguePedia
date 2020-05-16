package com.example.mappers;

import com.example.assignment.AssignmentDTO;
import com.example.assignment.Assignment;

public class AssignmentMapper {
//    public static Assignment toEntity(AssignmentDTO dto) {
//
//    }

    public static AssignmentDTO toDTO(Assignment entity) {
        return new AssignmentDTO(
                entity.getObjectId().toString(),
                entity.getPlayer().getFirstName(),
                entity.getTeam().getName(),
                entity.getTeam().getId().toString(),
                entity.getStart(),
                entity.getEnd()
        );
    }
}
