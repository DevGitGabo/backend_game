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
public class User {
    @Id private String id;
    @Indexed(unique = true) @NonNull private String name;
    @Indexed(unique = true) @NonNull private String email;
    @NonNull private String password;
    private int money;
    private int levelUser;
    private int xp;
    private List<String> achievements;
    private int levelHistory;
    private Range range;
    private int win_multiplayer;
    private int lose_multiplayer;
    private Role role;

    public User(String name, String email, String password, int money, int levelUser, int xp, List<String> achievements, int levelHistory, Range range, int win_multiplayer, int lose_multiplayer, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.money = money;
        this.levelUser = levelUser;
        this.xp = xp;
        this.achievements = achievements;
        this.levelHistory = levelHistory;
        this.range = range;
        this.win_multiplayer = win_multiplayer;
        this.lose_multiplayer = lose_multiplayer;
        this.role = role;
    }
}
