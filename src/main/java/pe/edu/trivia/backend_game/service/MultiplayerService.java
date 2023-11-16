package pe.edu.trivia.backend_game.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.trivia.backend_game.collection.Multiplayer;
import pe.edu.trivia.backend_game.repository.MultiplayerRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class MultiplayerService {

    private final MultiplayerRepository multiplayerRepository;
    public List<Multiplayer> getAllMultiplayer() {
        return multiplayerRepository.findAll();
    }
}