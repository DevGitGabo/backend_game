package pe.edu.trivia.backend_game.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.trivia.backend_game.collection.Level;
import pe.edu.trivia.backend_game.repository.LevelRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class LevelService {

    private final LevelRepository levelRepository;
    public List<Level> getAllLevels() {
            return levelRepository.findAll();
        }
}
