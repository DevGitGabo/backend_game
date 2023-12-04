package pe.edu.trivia.backend_game.security.models;

import pe.edu.trivia.backend_game.collection.User;

public class UserWithTokenResponse {
    private User user;
    private String token;

    public UserWithTokenResponse(User user, String token)
 
{
        this.user = user;
        this.token = token;
    }

    public User getUser()
 
{
        return user;
    }

    public String getToken()
 
{
        return token;
    }
}