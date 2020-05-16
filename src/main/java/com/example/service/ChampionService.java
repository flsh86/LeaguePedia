package com.example.service;

import com.example.champion.Champion;
import com.example.champion.ChampionDTO;
import com.example.mappers.ChampionMapper;
import com.example.repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChampionService {
    private ChampionRepository championRepository;

    @Autowired
    public ChampionService(ChampionRepository championRepository) {
        this.championRepository = championRepository;
    }

    public List<ChampionDTO> findAll() {
        return this.championRepository.findAll()
                .stream()
                .map(ChampionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void save(ChampionDTO dto) {
        Champion entity = ChampionMapper.toEntity(dto);
        this.championRepository.save(entity);
    }
}
