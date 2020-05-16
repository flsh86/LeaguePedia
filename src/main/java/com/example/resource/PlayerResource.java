package com.example.resource;

import com.example.service.PlayerService;
import com.example.player.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerResource {
    private PlayerService playerService;

    @Autowired
    public PlayerResource(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlayerDTO>> findAll(
            @RequestParam(required = false) String name) {
        List<PlayerDTO> dto;
        if(name != null) {
            dto = this.playerService.findByFirstName(name);
        } else {
            dto = this.playerService.findAll();
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayerDTO> addUser(@RequestBody PlayerDTO dto) {
        this.playerService.save(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(location).body(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<PlayerDTO> findById(@PathVariable String id) {
        PlayerDTO dto = this.playerService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/champions")
    public ResponseEntity<List<PlayerDTO>> findByTeamName(@RequestParam(name = "champion_name") String championName) {
        List<PlayerDTO> dto = this.playerService.findByChampionName(championName);
        return ResponseEntity.ok(dto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<PlayerDTO> updateUser(@PathVariable String id, @RequestBody PlayerDTO dto) {
        this.playerService.save(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();

        return ResponseEntity.noContent().location(location).build();
    }
}
