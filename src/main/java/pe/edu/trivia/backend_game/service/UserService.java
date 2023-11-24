package pe.edu.trivia.backend_game.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.trivia.backend_game.collection.User;
import pe.edu.trivia.backend_game.logic.UserValidator;
import pe.edu.trivia.backend_game.repository.UserRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserValidator userValidator;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public List<User> searchUsers(String keyword) {
        return userRepository.search(keyword);
    }
    public String save(User user) {
        final String[] mensaje = new String[1];

        try {
            userValidator.validateUser(user);
            userRepository.insert(user);
            mensaje[0] = "Insertando usuario " + user;
        } catch (UserValidator.NotUserValidException e) {
            mensaje[0] = e.getMessage();
        }

        return mensaje[0];
    }
}
