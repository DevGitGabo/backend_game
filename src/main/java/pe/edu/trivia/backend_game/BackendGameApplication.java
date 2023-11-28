package pe.edu.trivia.backend_game;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import pe.edu.trivia.backend_game.collection.*;
import pe.edu.trivia.backend_game.logic.LevelValidator;
import pe.edu.trivia.backend_game.logic.MultiplayerValidator;
import pe.edu.trivia.backend_game.logic.QuestionValidator;
import pe.edu.trivia.backend_game.logic.UserValidator;
import pe.edu.trivia.backend_game.repository.LevelRepository;
import pe.edu.trivia.backend_game.repository.MultiplayerRepository;
import pe.edu.trivia.backend_game.repository.QuestionRepository;
import pe.edu.trivia.backend_game.repository.UserRepository;
import pe.edu.trivia.backend_game.service.LevelService;
import pe.edu.trivia.backend_game.service.MultiplayerService;
import pe.edu.trivia.backend_game.service.QuestionService;
import pe.edu.trivia.backend_game.service.UserService;

import java.util.List;

import static pe.edu.trivia.backend_game.collection.Range.BRONZE;
import static pe.edu.trivia.backend_game.collection.Role.ADMIN;
import static pe.edu.trivia.backend_game.collection.Type.NUMERICAL;

@SpringBootApplication
public class BackendGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendGameApplication.class, args);
	}

	@Bean
	CommandLineRunner runner (UserRepository userRepository,
							  QuestionRepository questionRepository,
							  MultiplayerRepository multiplayerRepository,
							  LevelRepository levelRepository, PasswordEncoder passwordEncoder){
		return args -> {
			final UserValidator userValidator = new UserValidator(userRepository);
			final UserService userService = new UserService(userRepository,userValidator, passwordEncoder);


			final QuestionValidator questionValidator = new QuestionValidator(questionRepository);
			final QuestionService questionService = new QuestionService(questionRepository, questionValidator);

			final MultiplayerValidator multiplayerValidator = new MultiplayerValidator(multiplayerRepository);
			final MultiplayerService multiplayerService = new MultiplayerService(multiplayerRepository, multiplayerValidator);

			final LevelValidator levelValidator = new LevelValidator(levelRepository);
			final LevelService levelService = new LevelService(levelRepository, levelValidator);

			User user = new User(
					"Gabriel",
					"Gabriel@gmail.com",
					"Gabriel",
					1000,
					15,
					1000,
					List.of("Wow"),
					14,
					BRONZE,
					12,
					12,
					ADMIN
			);

			Question question = new Question(
					"¿Pregunta 1?",
					List.of("Test"),
					NUMERICAL,
					List.of("1","2","3","4"),
					"4"
			);

			Level level = new Level(
					"Level 1",
					1,
					List.of(question),
					"This level 1.",
					true
			);

			Multiplayer multiplayer = new Multiplayer(
					List.of(user),
					List.of(question),
					List.of(2,3),
					user
			);

			userService.save(user);
			questionService.save(question);
			levelService.save(level);
			multiplayerService.save(multiplayer);
		};
	}
}
