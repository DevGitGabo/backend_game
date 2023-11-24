package pe.edu.trivia.backend_game.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Level {
    @Id private String id;
    @Indexed(unique = true) @NonNull private String name;
    @Indexed(unique = true) private int level;
    private List<Question> questions;
    private String description;
    @NonNull private boolean completed;

    public Level(@NonNull String name, int level, List<Question> questions, String description, @NonNull boolean completed) {
        this.name = name;
        this.level = level;
        this.questions = questions;
        this.description = description;
        this.completed = completed;
    }
}
