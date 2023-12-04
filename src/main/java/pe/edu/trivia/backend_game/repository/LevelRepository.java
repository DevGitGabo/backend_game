package pe.edu.trivia.backend_game.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pe.edu.trivia.backend_game.collection.Level;
import pe.edu.trivia.backend_game.collection.Question;

import java.util.List;
import java.util.Optional;

public interface LevelRepository extends MongoRepository<Level,String> {
    boolean existsByName(String name);
    boolean existsByLevel(int level);
    List<Level> findByLevel(int text);
    Optional<Level> findByName(String name);

}
