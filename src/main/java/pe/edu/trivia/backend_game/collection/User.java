package pe.edu.trivia.backend_game.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id private String id;
    @NonNull private String username;
    @NonNull private String email;
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
    private Set<RolAuth> rolAuth;
    public User(String id, @NonNull String username, @NonNull String email, @NonNull String password, int money, int levelUser, int xp,
                List<String> achievements, int levelHistoryMode, Range range, int win_multiplayerMode,
                int lose_multiplayerMode, Role role) {
        super();
        this.id = id;
        this.username = username;
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

        Set<RolAuth> roles = new HashSet<>();

        if (role.equals(Role.ADMIN)){
            roles.add(new RolAuth("ADMIN"));
        }else {
            roles.add(new RolAuth("USER"));
        }

        this.rolAuth = roles;
    }
    public User(@NonNull String username, @NonNull String email, @NonNull String password, int money, int levelUser, int xp,
                List<String> achievements, int levelHistoryMode, Range range, int win_multiplayerMode,
                int lose_multiplayerMode, Role role) {
        super();
        this.username = username;
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

        Set<RolAuth> roles = new HashSet<>();

        if (role.equals(Role.ADMIN)){
            roles.add(new RolAuth("ADMIN"));
        }else {
            roles.add(new RolAuth("USER"));
        }

        this.rolAuth = roles;
    }

    public User(@NonNull String username, @NonNull String email, @NonNull String password, Role role) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.range = Range.BRONZE;

        Set<RolAuth> roles = new HashSet<>();

        if (role.equals(Role.ADMIN)){
            roles.add(new RolAuth("ADMIN"));
        }else {
            roles.add(new RolAuth("USER"));
        }

        this.rolAuth = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.rolAuth;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.rolAuth = rolAuth;
    }

    @Override
    public @NonNull String getPassword() {
        return this.password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
