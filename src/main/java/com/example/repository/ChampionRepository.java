package com.example.repository;

import com.example.champion.Champion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChampionRepository extends MongoRepository<Champion, String> {
    List<Champion> findAllByNameContaining(String championName);
    Optional<Champion> findByName(String name);
}
