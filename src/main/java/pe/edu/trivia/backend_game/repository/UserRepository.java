package pe.edu.trivia.backend_game.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import pe.edu.trivia.backend_game.collection.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {
    @Query(
            "{'$or':[ " +
                    "{'name': {$regex : ?0, $options: 'i'}}, " +
                    "{'email': {$regex : ?0, $options: 'i'}}, " +
                    "{'achievements': {$in: [?0]}}, " +
                    "{'range': {$in: [?0]}}, " +
                    "{'role': {$in: [?0]}}, " +
                    "]}"
    )
    List<User> search(String keyword);

    boolean existsByName(String name);
    boolean existsByEmail(String email);

}
