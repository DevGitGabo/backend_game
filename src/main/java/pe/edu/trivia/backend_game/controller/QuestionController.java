package pe.edu.trivia.backend_game.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.trivia.backend_game.collection.Question;
import pe.edu.trivia.backend_game.logic.QuestionValidator;
import pe.edu.trivia.backend_game.repository.QuestionRepository;
import pe.edu.trivia.backend_game.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/api/question")
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionValidator questionValidator;
    private final QuestionRepository questionRepository;
    @GetMapping("/getAll")
    public List<Question> fetchAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/search")
    public List<Question> searchQuestions(@RequestParam String keyword) {
        return questionService.searchQuestions(keyword);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable String id, @RequestBody Question updatedQuestion) {
        return questionService.updateQuestion(id, updatedQuestion);
    }

    @PostMapping("/save")
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
        return questionService.save(question);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable String id) {
        return questionService.deleteQuestion(id);
    }

}