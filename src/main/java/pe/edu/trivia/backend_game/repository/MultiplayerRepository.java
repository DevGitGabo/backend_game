package pe.edu.trivia.backend_game.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pe.edu.trivia.backend_game.collection.Multiplayer;

public interface MultiplayerRepository extends MongoRepository<Multiplayer,String> {
}
