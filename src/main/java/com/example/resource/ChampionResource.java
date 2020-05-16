package com.example.resource;

import com.example.champion.ChampionDTO;
import com.example.service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/champion")
public class ChampionResource {
    private ChampionService championService;

    @Autowired
    public ChampionResource(ChampionService championService) {
        this.championService = championService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ChampionDTO>> findAll() {
        List<ChampionDTO> dto = this.championService.findAll();
        return ResponseEntity.ok(dto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChampionDTO> save(@RequestBody ChampionDTO dto) {
        this.championService.save(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.get_id())
                .toUri();

        return ResponseEntity.created(location).body(dto);
    }

}
