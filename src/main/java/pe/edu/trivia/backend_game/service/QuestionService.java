package pe.edu.trivia.backend_game.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.trivia.backend_game.collection.Question;
import pe.edu.trivia.backend_game.logic.QuestionValidator;
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
        return questionRepository.findByType(keyword);
    }
    public ResponseEntity<Question> save(Question question) {
        try {
            questionValidator.validateQuestion(question);
            questionRepository.insert(question);
            return ResponseEntity.ok(question); // Devuelve la pregunta insertada
        } catch (QuestionValidator.NotQuestionValidException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Otra opción, dependiendo de tu lógica
        }
    }

    public Question getQuestionById(String id) {
        return questionRepository.findById(id).orElse(null);
    }

    public ResponseEntity<Question> updateQuestion(String id, Question updatedQuestion) {
        try {
            Question existingQuestion = getQuestionById(id);
            if (existingQuestion == null) {
                return ResponseEntity.notFound().build();
            }

            // Realiza las actualizaciones necesarias en existingQuestion usando los datos de updatedQuestion
            existingQuestion.setText(updatedQuestion.getText());
            existingQuestion.setTopics(updatedQuestion.getTopics());
            existingQuestion.setType(updatedQuestion.getType());
            existingQuestion.setOptions(updatedQuestion.getOptions());
            existingQuestion.setCorrectAnswer(updatedQuestion.getCorrectAnswer());

            // Guarda la pregunta actualizada en el repositorio
            questionRepository.save(existingQuestion);

            return ResponseEntity.ok(existingQuestion); // Devuelve la pregunta actualizada
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Otra opción, dependiendo de tu lógica
        }
    }

    public ResponseEntity<String> deleteQuestion(String id) {
        try {
            questionRepository.deleteById(id);
            return ResponseEntity.ok("Pregunta eliminada con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la pregunta");
        }
    }

}