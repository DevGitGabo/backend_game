package pe.edu.trivia.backend_game.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.trivia.backend_game.collection.Multiplayer;
import pe.edu.trivia.backend_game.collection.User;
import pe.edu.trivia.backend_game.logic.MultiplayerValidator;
import pe.edu.trivia.backend_game.logic.QuestionValidator;
import pe.edu.trivia.backend_game.repository.MultiplayerRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MultiplayerService {

    private final MultiplayerRepository multiplayerRepository;
    private final MultiplayerValidator multiplayerValidator;
    public List<Multiplayer> getAllMultiplayer() {
        return multiplayerRepository.findAll();
    }
    public Optional<Multiplayer> searchGames(String keyword) {
        return multiplayerRepository.findById(keyword);
    }

    public String save(Multiplayer multiplayer) {
        final String[] mensaje = new String[1];

        try {
            multiplayerValidator.validateMultiplayer(multiplayer);
            multiplayerRepository.insert(multiplayer);
            mensaje[0] = "Insertando juego " + multiplayer;
        } catch (MultiplayerValidator.NotMultiplayerValidException e) {
            mensaje[0] = e.getMessage();
        }

        return mensaje[0];
    }
}