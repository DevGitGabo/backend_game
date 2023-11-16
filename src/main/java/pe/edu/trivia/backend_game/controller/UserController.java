package pe.edu.trivia.backend_game.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.trivia.backend_game.collection.User;
import pe.edu.trivia.backend_game.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private  final UserService userService;

    @GetMapping("/getAll")
    public List<User> fetchAllUsers(){
        return userService.getAllUsers();
    }
}
