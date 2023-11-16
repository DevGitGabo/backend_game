package pe.edu.trivia.backend_game.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Multiplayer {
    @Id
    private String id;
    private List<User> users;
    private List<Question> questions;
    private List<Integer> point;
    private User winner;
    private Date date;

    public Multiplayer(List<User> users, List<Question> questions, List<Integer> point, User winner, Date date) {
        this.users = users;
        this.questions = questions;
        this.point = point;
        this.winner = winner;
        this.date = date;
    }
}
