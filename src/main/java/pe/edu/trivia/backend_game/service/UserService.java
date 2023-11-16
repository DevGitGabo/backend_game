package pe.edu.trivia.backend_game.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.trivia.backend_game.collection.User;
import pe.edu.trivia.backend_game.repository.UserRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
