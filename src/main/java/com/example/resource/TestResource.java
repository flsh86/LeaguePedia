//package com.example.resource;
//
//import com.example.repository.PlayerRepository;
//import com.example.player.Player;
//import lombok.AllArgsConstructor;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/test")
//@AllArgsConstructor
//public class TestResource {
//    private PlayerRepository playerRepository;
//
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> findAll() {
//        List<Player> players = playerRepository.findAll();
//        return ResponseEntity.ok(players);
//    }
//}
