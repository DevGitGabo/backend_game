package pe.edu.trivia.backend_game.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.trivia.backend_game.collection.Question;
import pe.edu.trivia.backend_game.collection.User;
import pe.edu.trivia.backend_game.logic.QuestionValidator;
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

    public ResponseEntity<User> save(User user) {
        try {
            userValidator.validateUser(user);
            userRepository.insert(user);
            return ResponseEntity.ok(user); // Devuelve la pregunta insertada
        } catch (UserValidator.NotUserValidException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Otra opción, dependiendo de tu lógica
        }
    }

    public ResponseEntity<String> deleteUser(String id) {
        try {
            userRepository.deleteById(id);
            return ResponseEntity.ok("Pregunta eliminada con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la pregunta");
        }
    }

    public ResponseEntity<User> updateUser(String id, User updatedUser) {
        try {
            User existingUser = getUserById(id);
            if (existingUser == null) {
                return ResponseEntity.notFound().build();
            }

            // Realiza las actualizaciones necesarias en existingUser usando los datos de updatedUser
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setMoney(updatedUser.getMoney());
            existingUser.setLevelUser(updatedUser.getLevelUser());
            existingUser.setXp(updatedUser.getXp());
            existingUser.setAchievements(updatedUser.getAchievements());
            existingUser.setLevelHistoryMode(updatedUser.getLevelHistoryMode());
            existingUser.setRange(updatedUser.getRange());
            existingUser.setWin_multiplayerMode(updatedUser.getWin_multiplayerMode());
            existingUser.setLose_multiplayerMode(updatedUser.getLose_multiplayerMode());
            existingUser.setRole(updatedUser.getRole());

            // Guarda el usuario actualizado en el repositorio
            userRepository.save(existingUser);

            return ResponseEntity.ok(existingUser); // Devuelve el usuario actualizado
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Otra opción, dependiendo de tu lógica
        }
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }
}
