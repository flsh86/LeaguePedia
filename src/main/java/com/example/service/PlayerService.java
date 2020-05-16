package com.example.service;

import com.example.mappers.PlayerMapper;
import com.example.repository.PlayerRepository;
import com.example.player.Player;
import com.example.player.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.mappers.validators.Validators.validName;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<PlayerDTO> findAll() {
        return this.playerRepository.findAll()
                .stream()
                .map(PlayerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PlayerDTO findById(String id) {
        if(id == null || id.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Input correct id");
        }

        return this.playerRepository.findById(id)
                .map(PlayerMapper::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<PlayerDTO> findByChampionName(String championName) {
        if(championName == null || championName.isEmpty()) {
            return findAll();
        }

        return this.playerRepository.findAllByChampions_Name(championName)
                .stream()
                .map(PlayerMapper::toDTO)
                .collect(Collectors.toList());

    }

    public void save(PlayerDTO dto) {
        if(!validName(dto.getFirstName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insert valid first name");
        }

        if(!validName(dto.getLastName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insert valid last name");

        }

        if(!validName(dto.getNick())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insert valid nick");
        }

        if(dto.getStatus() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status has to be active or inactive");
        }
/*
        if(dto.getCurrentTeam() == null
                // || if findTeam returns no valid team, set player team to teamless
        ) {

            dto.setCurrentTeam(TEAMLESS);
        }

 */
        Player entity = PlayerMapper.toEntity(dto);
        this.playerRepository.save(entity);
    }

    public List<PlayerDTO> findByFirstName(String name) {
        if(name == null || name.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "INPUT CORRECT NAME");
        }

        return this.playerRepository.findByFirstName(name)
                .stream()
                .map(PlayerMapper::toDTO)
                .collect(Collectors.toList());
    }

}
