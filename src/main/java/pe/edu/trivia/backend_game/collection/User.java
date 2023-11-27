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
    private int levelHistoryMode;
    private Range range;
    private int win_multiplayerMode;
    private int lose_multiplayerMode;
    private Role role;

    public User(@NonNull String name, @NonNull String email, @NonNull String password, int money, int levelUser, int xp,
                List<String> achievements, int levelHistoryMode, Range range, int win_multiplayerMode,
                int lose_multiplayerMode, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.money = money;
        this.levelUser = levelUser;
        this.xp = xp;
        this.achievements = achievements;
        this.levelHistoryMode = levelHistoryMode;
        this.range = range;
        this.win_multiplayerMode = win_multiplayerMode;
        this.lose_multiplayerMode = lose_multiplayerMode;
        this.role = role;
    }

    public User(@NonNull String name, @NonNull String email, @NonNull String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
