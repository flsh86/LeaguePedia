package com.example.repository;

import com.example.player.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
//    Optional<User> findById(ObjectId _id);
    List<Player> findAllByChampions_Name(String championName);
    List<Player> findByFirstName(String name);
}
