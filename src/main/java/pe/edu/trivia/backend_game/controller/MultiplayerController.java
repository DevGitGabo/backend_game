package pe.edu.trivia.backend_game.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.trivia.backend_game.collection.Multiplayer;
import pe.edu.trivia.backend_game.service.MultiplayerService;

import java.util.List;

@RestController
@RequestMapping("/api/match")
@AllArgsConstructor
public class MultiplayerController {

    private final MultiplayerService multiplayerService;
    @GetMapping("/getAll")
    public List<Multiplayer> fetchAllGamesOnline(){
        return multiplayerService.getAllMultiplayer();
    }
}