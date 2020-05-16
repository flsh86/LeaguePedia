package com.example.service;

import com.example.mappers.TeamMapper;
import com.example.repository.TeamRepository;
import com.example.team.Team;
import com.example.team.TeamDTO;
//import com.example.team.TeamDTODwa;
//import com.example.team.TeamDTODwaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public TeamDTO findById(String id) {
        if(id == null || id.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return teamRepository.findById(id)
                .map(TeamMapper::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TeamDTO> findAll() {
        return this.teamRepository.findAll()
                .stream()
                .map(TeamMapper::toDTO)
                .collect(Collectors.toList());
    }

//    public List<TeamDTODwa> testy() {
//        return this.teamRepository.findAll()
//                .stream()
//                .map(TeamDTODwaMapper::toDTO)
//                .collect(Collectors.toList());
//    }

}
