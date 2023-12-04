package pe.edu.trivia.backend_game.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.trivia.backend_game.collection.Level;
import pe.edu.trivia.backend_game.collection.Multiplayer;
import pe.edu.trivia.backend_game.collection.Question;
import pe.edu.trivia.backend_game.service.MultiplayerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/match")
@AllArgsConstructor
public class MultiplayerController {

    private final MultiplayerService multiplayerService;
    @GetMapping("/getAll")
    public List<Multiplayer> fetchAllGamesOnline(){
        return multiplayerService.getAllMultiplayer();
    }
    @PostMapping("/save")
    public String saveMultiplayer(@RequestBody Multiplayer multiplayer) {
        return multiplayerService.save(multiplayer);
    }

    @PostMapping("/search")
    public Optional<Multiplayer> searchGames(@RequestParam String keyword) {
        return multiplayerService.searchGames(keyword);
    }
}