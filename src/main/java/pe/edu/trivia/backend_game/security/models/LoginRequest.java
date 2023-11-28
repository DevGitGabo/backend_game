package pe.edu.trivia.backend_game.security.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class LoginRequest {
    private String name;
    private String password;

    // Constructores, getters y setters

    public LoginRequest() {
    }

    public LoginRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Getters y setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
