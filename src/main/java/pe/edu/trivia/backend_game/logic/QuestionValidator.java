package pe.edu.trivia.backend_game.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.trivia.backend_game.collection.Question;
import pe.edu.trivia.backend_game.repository.QuestionRepository;

@Component
public class QuestionValidator {
    private QuestionRepository questionRepository;

    @Autowired
    public QuestionValidator(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void validateQuestion(Question question) throws NotQuestionValidException {
        validateText(question.getText());
        validateCorrectAnswer(question.getCorrectAnswer());
    }

    private void validateText(String text) throws NotQuestionValidException {
        if (questionRepository.existsByText(text)) {
            throw new NotQuestionValidException("Ya existe una pregunta con el texto: " + text);
        }
    }

    private void validateCorrectAnswer(String correctAnswer) throws NotQuestionValidException {
        if (correctAnswer == null) {
            throw new NotQuestionValidException("La respuesta correcta no puede ser nula");
        }
    }

    public static class NotQuestionValidException extends Exception {
        public NotQuestionValidException(String message) {
            super(message);
        }
    }
}
