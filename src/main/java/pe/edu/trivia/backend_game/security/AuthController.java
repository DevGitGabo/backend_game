package pe.edu.trivia.backend_game.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.trivia.backend_game.collection.User;
import pe.edu.trivia.backend_game.security.models.LoginRequest;
import pe.edu.trivia.backend_game.security.models.RegisterRequest;
import pe.edu.trivia.backend_game.security.models.UserWithTokenResponse;
import pe.edu.trivia.backend_game.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest) {
        try {
            authService.registerUser(registerRequest.getName(), registerRequest.getEmail(), registerRequest.getPassword());
            return ResponseEntity.ok("Usuario registrado con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }

    @PostMapping("/login")
    public UserWithTokenResponse authenticateUser(@RequestBody LoginRequest loginRequest) {
        UserWithTokenResponse userWithTokenResponse = authService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
        return userWithTokenResponse;
    }
}
