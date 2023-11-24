package pe.edu.trivia.backend_game.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.trivia.backend_game.collection.Question;
import pe.edu.trivia.backend_game.collection.User;
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
    @PostMapping("/search")
    public List<Question> searchQuestions(@RequestParam String keyword) {
        return questionService.searchQuestions(keyword);
    }
    @PostMapping("/save")
    public String saveQuestion(@RequestBody Question question) {
        return questionService.save(question);
    }
}