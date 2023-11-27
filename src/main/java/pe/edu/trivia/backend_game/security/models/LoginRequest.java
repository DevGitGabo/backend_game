package pe.edu.trivia.backend_game.security.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class LoginRequest {
    private String email;
    private String password;

    // Constructores, getters y setters

    public LoginRequest() {
    }

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters y setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
