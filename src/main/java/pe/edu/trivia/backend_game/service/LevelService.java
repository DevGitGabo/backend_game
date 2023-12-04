package pe.edu.trivia.backend_game.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.trivia.backend_game.collection.Level;
import pe.edu.trivia.backend_game.collection.Multiplayer;
import pe.edu.trivia.backend_game.logic.LevelValidator;
import pe.edu.trivia.backend_game.logic.MultiplayerValidator;
import pe.edu.trivia.backend_game.repository.LevelRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LevelService {

    private final LevelRepository levelRepository;
    private final LevelValidator levelValidator;

    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }
    public List<Level> searchLevels(String keyword) {
        return levelRepository.findByLevel(Integer.parseInt(keyword));
    }
    public String save(Level level) {
        final String[] mensaje = new String[1];

        try {
            levelValidator.validateLevel(level);
            levelRepository.insert(level);
            mensaje[0] = "Insertando nivel " + level;
        } catch (LevelValidator.NotLevelValidException e) {
            mensaje[0] = e.getMessage();
        }

        return mensaje[0];
    }

    public String updateLevel(Level updatedLevel) {
        Optional<Level> optionalLevel = levelRepository.findById(updatedLevel.getId());

        if (optionalLevel.isPresent()) {
            Level level = optionalLevel.get();
            // Actualizar todas las propiedades relevantes del nivel con los valores del nivel actualizado
            level.setName(updatedLevel.getName());
            level.setLevel(updatedLevel.getLevel());
            level.setQuestions(updatedLevel.getQuestions());
            level.setDescription(updatedLevel.getDescription());
            level.setCompleted(updatedLevel.isCompleted());

            levelRepository.save(level);
            return "Nivel actualizado exitosamente.";
        } else {
            return "No se encontró el nivel con ID: " + updatedLevel.getId();
        }
    }
}

