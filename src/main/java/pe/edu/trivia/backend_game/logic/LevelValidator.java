package pe.edu.trivia.backend_game.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.trivia.backend_game.collection.Level;
import pe.edu.trivia.backend_game.repository.LevelRepository;

@Component
public class LevelValidator {
    private LevelRepository levelRepository;

    @Autowired
    public LevelValidator(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    public void validateLevel(Level level) throws NotLevelValidException {
        validateName(level.getName());
        validateLevelValue(level.getLevel());
    }

    private void validateName(String name) throws NotLevelValidException {
        if (levelRepository.existsByName(name)) {
            throw new NotLevelValidException("Ya existe un nivel con el nombre: " + name);
        }
    }

    private void validateLevelValue(int level) throws NotLevelValidException {
        if (levelRepository.existsByLevel(level)) {
            throw new NotLevelValidException("Ya existe un nivel con el valor: " + level);
        }
    }

    public static class NotLevelValidException extends Exception {
        public NotLevelValidException(String message) {
            super(message);
        }
    }
}
