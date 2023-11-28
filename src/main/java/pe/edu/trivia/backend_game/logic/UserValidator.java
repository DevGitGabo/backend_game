package pe.edu.trivia.backend_game.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.trivia.backend_game.collection.User;
import pe.edu.trivia.backend_game.repository.UserRepository;

@Component
public class UserValidator {
    private UserRepository userRepository;

    @Autowired
    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateUser(User user) throws NotUserValidException {
        validateName(user.getUsername());
        validateEmail(user.getEmail());
    }

    private void validateName(String username) throws NotUserValidException {
        if (userRepository.existsByUsername(username)) {
            throw new NotUserValidException("Ya existe un usuario con el nombre: " + username);
        }
    }

    private void validateEmail(String email) throws NotUserValidException {
        if (userRepository.existsByEmail(email)) {
            throw new NotUserValidException("Ya existe un usuario con el correo electrónico: " + email);
        }
    }

    public static class NotUserValidException extends Exception {
        public NotUserValidException(String message) {
            super(message);
        }
    }
}


