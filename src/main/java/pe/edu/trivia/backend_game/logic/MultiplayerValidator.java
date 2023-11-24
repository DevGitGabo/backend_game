package pe.edu.trivia.backend_game.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.trivia.backend_game.collection.Multiplayer;
import pe.edu.trivia.backend_game.collection.Question;
import pe.edu.trivia.backend_game.collection.User;
import pe.edu.trivia.backend_game.repository.MultiplayerRepository;

import java.util.Date;
import java.util.List;

@Component
public class MultiplayerValidator {
    private MultiplayerRepository multiplayerRepository;

    @Autowired
    public MultiplayerValidator(MultiplayerRepository multiplayerRepository) {
        this.multiplayerRepository = multiplayerRepository;
    }

    public void validateMultiplayer(Multiplayer multiplayer) throws NotMultiplayerValidException {
        validateUsers(multiplayer.getUsers());
        validateQuestions(multiplayer.getQuestions());
        validateWinner(multiplayer.getWinner());
    }

    private void validateUsers(List<User> users) throws NotMultiplayerValidException {
        // Puedes agregar lógica de validación específica para la lista de usuarios si es necesario.
        // Por ejemplo, verificar que la lista no esté vacía.
        if (users == null || users.isEmpty()) {
            throw new NotMultiplayerValidException("La lista de usuarios no puede ser nula o vacía");
        }
    }

    private void validateQuestions(List<Question> questions) throws NotMultiplayerValidException {
        // Puedes agregar lógica de validación específica para la lista de preguntas si es necesario.
        // Por ejemplo, verificar que la lista no esté vacía.
        if (questions == null || questions.isEmpty()) {
            throw new NotMultiplayerValidException("La lista de preguntas no puede ser nula o vacía");
        }
    }

    private void validateWinner(User winner) throws NotMultiplayerValidException {
        if (winner == null) {
            throw new NotMultiplayerValidException("El ganador no puede ser nulo");
        }
    }
    public static class NotMultiplayerValidException extends Exception {
        public NotMultiplayerValidException(String message) {
            super(message);
        }
    }
}
