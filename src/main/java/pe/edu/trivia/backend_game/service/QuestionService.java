package pe.edu.trivia.backend_game.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.trivia.backend_game.collection.Question;
import pe.edu.trivia.backend_game.repository.QuestionRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}