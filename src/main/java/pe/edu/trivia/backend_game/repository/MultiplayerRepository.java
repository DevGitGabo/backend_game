package pe.edu.trivia.backend_game.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import pe.edu.trivia.backend_game.collection.Multiplayer;
import pe.edu.trivia.backend_game.collection.Question;

import java.util.List;

public interface MultiplayerRepository extends MongoRepository<Multiplayer,String> {
}
