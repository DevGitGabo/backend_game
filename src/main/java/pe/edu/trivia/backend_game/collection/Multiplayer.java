package pe.edu.trivia.backend_game.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Multiplayer {
    @Id private String id;
    @NonNull private List<User> users;
    @NonNull private List<Question> questions;
    private List<Integer> point;
    @NonNull private User winner;
    @NonNull @CreatedDate private Date date;

    public Multiplayer(List<User> users, List<Question> questions, List<Integer> point, User winner) {
        this.users = users;
        this.questions = questions;
        this.point = point;
        this.winner = winner;
    }
}
