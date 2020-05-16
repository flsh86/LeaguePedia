//package com.example.team;
//
//import com.example.assignment.AssignmentDTO;
//import com.example.mappers.AssignmentMapper;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class TeamDTODwaMapper {
//    public static TeamDTODwa toDTO(Team team) {
//        List<AssignmentDTO> assignmentDTOS = team.getAssignments()
//                .stream()
//                .map(AssignmentMapper::toDTO)
//                .collect(Collectors.toList());
//
//        return new TeamDTODwa(
//                team.getName(),
//                assignmentDTOS
//        );
//    }
//}
