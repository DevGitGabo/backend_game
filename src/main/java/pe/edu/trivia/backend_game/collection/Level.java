package pe.edu.trivia.backend_game.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Level {
    @Id
    private String id;
    private String name;
    private int level;
    private List<Question> questions;
    private String description;

    public Level(String name, int level, List<Question> questions, String description) {
        this.name = name;
        this.level = level;
        this.questions = questions;
        this.description = description;
    }
}
