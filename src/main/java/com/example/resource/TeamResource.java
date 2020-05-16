package com.example.resource;

import com.example.service.TeamService;
import com.example.team.TeamDTO;
//import com.example.team.TeamDTODwa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamResource {
    private TeamService teamService;

    @Autowired
    public TeamResource(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TeamDTO>> findAll() {
        List<TeamDTO> dto = this.teamService.findAll();
        return ResponseEntity.ok(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<TeamDTO> findById(@PathVariable String id) {
        TeamDTO dto = this.teamService.findById(id);
        return ResponseEntity.ok(dto);
    }

//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/testy")
//    public ResponseEntity<List<TeamDTODwa>> testy() {
//        List<TeamDTODwa> dto = this.teamService.testy();
//        return ResponseEntity.ok(dto);
//    }
}
