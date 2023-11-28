package pe.edu.trivia.backend_game.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.trivia.backend_game.collection.Role;
import pe.edu.trivia.backend_game.collection.User;
import pe.edu.trivia.backend_game.logic.UserValidator;
import pe.edu.trivia.backend_game.repository.UserRepository;

@Service
@Transactional
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(String username, String email, String password) throws UserValidationException, UserValidator.NotUserValidException {

        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(username,email,encodedPassword,Role.USER);

        try {
            userValidator = new UserValidator(userRepository);
            userValidator.validateUser(user);
            userRepository.insert(user);
        } catch (UserValidator.NotUserValidException e) {
            throw new UserValidator.NotUserValidException("Error de validación: " + e.getMessage());
        }
    }

    public class UserValidationException extends Exception {
        public UserValidationException(String message) {
            super(message);
        }
    }


    public String authenticateUser(String username, String password) {
        // Lógica de autenticación
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        return tokenService.generateJwt(authentication);
    }
}
