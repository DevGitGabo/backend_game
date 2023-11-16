package pe.edu.trivia.backend_game.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pe.edu.trivia.backend_game.collection.Question;

public interface QuestionRepository extends MongoRepository<Question,String>{
}
