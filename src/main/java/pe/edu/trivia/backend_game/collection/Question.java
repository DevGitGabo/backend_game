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
public class Question {
    @Id private String id;
    @NonNull private String text;
    private List<String> topics;
    private Type type;
    private List<String> options;
    @NonNull private String correctAnswer;

    public Question(String text, List<String> topics, Type type, List<String> options, String correctAnswer) {
        this.text = text;
        this.topics = topics;
        this.type = type;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public Question(String text, List<String> topics, Type type, String correctAnswer) {
        this.text = text;
        this.topics = topics;
        this.type = type;
        this.correctAnswer = correctAnswer;
    }
}
