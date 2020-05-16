package com.example.resource;

import com.example.assignment.Assignment;
import com.example.assignment.AssignmentDTO;
import com.example.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/assignment")
public class AssignmentResource {
    private AssignmentService assignmentService;

    @Autowired
    public AssignmentResource(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AssignmentDTO>> findAll() {
        List<AssignmentDTO> dto = this.assignmentService.findAll();
        return ResponseEntity.ok(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{team_id}")
    public ResponseEntity<List<AssignmentDTO>> findByTeamID(@PathVariable(name = "team_id") String id) {
        List<AssignmentDTO> dto = this.assignmentService.findByTeamID(id);
        return ResponseEntity.ok(dto);
    }
}
