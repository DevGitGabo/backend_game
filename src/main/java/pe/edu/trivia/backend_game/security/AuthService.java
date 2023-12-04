package pe.edu.trivia.backend_game.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import pe.edu.trivia.backend_game.security.models.UserWithTokenResponse;

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

    public UserWithTokenResponse authenticateUser(String username, String password) {
        // Authenticate the user using Spring Security
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        // Get the authenticated user object
        User user = (User) authentication.getPrincipal();

        // Generate the JWT token
        String token = tokenService.generateJwt(authentication);

        // Return a response containing both the user and the token
        return new UserWithTokenResponse(user, token);
    }
}
