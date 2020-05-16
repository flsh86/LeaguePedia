package com.example.service;

import com.example.assignment.AssignmentDTO;
import com.example.mappers.AssignmentMapper;
import com.example.repository.AssignmentRepository;
//import com.example.team.Team;
//import com.example.team.TeamDTODwa;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentService {
    private AssignmentRepository assignmentRepository;

    @Autowired
    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public List<AssignmentDTO> findAll() {
        return this.assignmentRepository.findAll()
                .stream()
                .map(AssignmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<AssignmentDTO> findByTeamID(String id) {
        ObjectId objectId = new ObjectId(id);
        return this.assignmentRepository.findAllByTeam_id(objectId)
                .stream()
                .map(AssignmentMapper::toDTO)
                .collect(Collectors.toList());
    }

}
