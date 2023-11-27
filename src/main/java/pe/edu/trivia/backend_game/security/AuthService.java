package pe.edu.trivia.backend_game.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.trivia.backend_game.collection.Role;
import pe.edu.trivia.backend_game.collection.User;
import pe.edu.trivia.backend_game.logic.UserValidator;
import pe.edu.trivia.backend_game.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserValidator userValidator;

    //@Autowired
    //private PasswordEncoder passwordEncoder;

    public User registerUser(String name, String email, String password) {

        // Crea el usuario con la contraseña encriptada
        // User user = new User(name, email, passwordEncoder.encode(password), Role.USER);
        User user = new User(name, email, password, Role.USER);
        try {
            userValidator.validateUser(user);
            userRepository.insert(user);
            return user; // Devuelve la pregunta insertada
        } catch (UserValidator.NotUserValidException e) {
            return user;
        }
    }
}
