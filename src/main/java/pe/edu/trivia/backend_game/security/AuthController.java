package pe.edu.trivia.backend_game.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.trivia.backend_game.collection.User;
import pe.edu.trivia.backend_game.security.models.LoginRequest;
import pe.edu.trivia.backend_game.security.models.RegisterRequest;
import pe.edu.trivia.backend_game.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
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
    public ResponseEntity<String> authenticateUser(@RequestBody LoginRequest loginRequest) {
        String token = authService.authenticateUser(loginRequest.getName(), loginRequest.getPassword());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/getAll")
    public List<User> fetchAllUsers(){
        return userService.getAllUsers();
    }
}
