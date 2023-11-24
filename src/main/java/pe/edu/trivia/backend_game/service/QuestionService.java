package pe.edu.trivia.backend_game.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.trivia.backend_game.collection.Question;
import pe.edu.trivia.backend_game.collection.User;
import pe.edu.trivia.backend_game.logic.QuestionValidator;
import pe.edu.trivia.backend_game.logic.UserValidator;
import pe.edu.trivia.backend_game.repository.QuestionRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionValidator questionValidator;
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
    public List<Question> searchQuestions(String keyword) {
        return questionRepository.findByText(keyword);
    }
    public String save(Question question) {
        final String[] mensaje = new String[1];

        try {
            questionValidator.validateQuestion(question);
            questionRepository.insert(question);
            mensaje[0] = "Insertando pregunta " + question;
        } catch (QuestionValidator.NotQuestionValidException e) {
            mensaje[0] = e.getMessage();
        }

        return mensaje[0];
    }
}