package pe.edu.trivia.backend_game.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pe.edu.trivia.backend_game.collection.Question;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question,String>{
    boolean existsByText(String text);
    List<Question> findByText(String text);
    List<Question> findByType(String text);
}
