package pe.edu.trivia.backend_game.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.trivia.backend_game.collection.Question;
import pe.edu.trivia.backend_game.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/api/question")
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    @GetMapping("/getAll")
    public List<Question> fetchAllQuestions(){
        return questionService.getAllQuestions();
    }
}