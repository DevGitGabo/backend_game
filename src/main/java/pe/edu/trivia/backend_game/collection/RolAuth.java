package pe.edu.trivia.backend_game.collection;

import org.springframework.security.core.GrantedAuthority;

public class RolAuth implements GrantedAuthority {
    private String authority;

    public RolAuth() {
        super();
    }

    public RolAuth(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
