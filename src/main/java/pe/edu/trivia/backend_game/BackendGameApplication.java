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

import static pe.edu.trivia.backend_game.collection.Range.*;
import static pe.edu.trivia.backend_game.collection.Role.ADMIN;
import static pe.edu.trivia.backend_game.collection.Role.USER;
import static pe.edu.trivia.backend_game.collection.Type.NUMERICAL;
import static pe.edu.trivia.backend_game.collection.Type.OPTIONS;

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
					List.of("EL PRIMER ADMIN"),
					14,
					BRONZE,
					12,
					12,
					ADMIN
			);

			User user1 = new User(
					"Alejandro",
					"Alejandro@gmail.com",
					"Alejandro",
					10001,
					12,
					10000,
					List.of("EL SEGUNDO ADMIN"),
					1,
					BRONZE,
					0,
					0,
					USER
			);

			User user2 = new User(
					"Gabo",
					"Gabo@gmail.com",
					"Gabo",
					5000,
					20,
					2000,
					List.of("Is The best..."),
					8,
					SILVER,
					8,
					8,
					USER
			);

			User user3 = new User(
					"Ale",
					"Ale@gmail.com",
					"Ale",
					7500,
					18,
					3000,
					List.of("ProPlayer"),
					10,
					GOLD,
					20,
					20,
					USER
			);

			userService.save(user);
			userService.save(user1);
			userService.save(user2);
			userService.save(user3);

			Question question = new Question(
					"¿Cuando es 5 + 4?",
					List.of("ARITMETICA"),
					NUMERICAL,
					"9"
			);

			Question question1 = new Question(
					"¿Cuál es la capital de Perú?",
					List.of("CIUDADES"),
					OPTIONS,
					List.of("Quito","Guayaquil","La Paz"),
					"Lima"
			);

			Question question2 = new Question(
					"¿Cuántos planetas hay en nuestro sistema solar?",
					List.of("CIENCIA"),
					NUMERICAL,
					"8"
			);

			Question question3 = new Question(
					"¿Quién escribió Romeo y Julieta?",
					List.of("LITERATURA"),
					OPTIONS,
					List.of("Hemingway", "Dickens", "Austen"),
					"Shakespeare"
			);

			Question question4 = new Question(
					"¿Cuál es el símbolo químico del oxígeno?",
					List.of("CIENCIA"),
					OPTIONS,
					List.of("K", "P", "Fe"),
					"O"
			);

			Question question5 = new Question(
					"¿En qué año comenzó la Segunda Guerra Mundial?",
					List.of("HISTORIA"),
					NUMERICAL,
					"1939"
			);

			Question question6 = new Question(
					"¿Cuál es la capital de Japón?",
					List.of("GEOGRAFÍA"),
					OPTIONS,
					List.of("Pekín", "Seúl","Bangkok"),
					"Tokio"
			);

			Question question7 = new Question(
					"¿Cuántos lados tiene un triángulo?",
					List.of("GEOMETRÍA"),
					NUMERICAL,
					"3"
			);

			Question question8 = new Question(
					"¿Cuál es el río más largo del mundo?",
					List.of("GEOGRAFÍA"),
					OPTIONS,
					List.of("Amazonas", "Nilo", "Yangtsé"),
					"Amazonas"
			);

			Question question9 = new Question(
					"¿Quién pintó La última cena?",
					List.of("ARTE"),
					OPTIONS,
					List.of("Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso"),
					"Leonardo da Vinci"
			);

			Question question10 = new Question(
					"¿Cuál es el elemento más abundante en la corteza terrestre?",
					List.of("CIENCIA"),
					OPTIONS,
					List.of("Oxígeno", "Silicio", "Aluminio"),
					"Oxígeno"
			);

			Question question11 = new Question(
					"¿Cuál es la lengua más hablada en el mundo?",
					List.of("IDIOMAS"),
					OPTIONS,
					List.of("Mandarín", "Español", "Inglés"),
					"Mandarín"
			);

			Question question12 = new Question(
					"¿Cuál es el escritor de 'Cien años de soledad'?",
					List.of("LITERATURA"),
					OPTIONS,
					List.of("Gabriel García Márquez", "Mario Vargas Llosa", "Isabel Allende"),
					"Gabriel García Márquez"
			);

			Question question13 = new Question(
					"¿En qué año se llevó a cabo la Revolución Rusa?",
					List.of("HISTORIA"),
					OPTIONS,
					List.of("1917", "1923", "1905"),
					"1917"
			);

			Question question14 = new Question(
					"¿Cuál es el océano más grande del mundo?",
					List.of("GEOGRAFÍA"),
					OPTIONS,
					List.of("Pacífico", "Atlántico", "Índico"),
					"Pacífico"
			);

			Question question15 = new Question(
					"¿Quién fue el primer presidente de los Estados Unidos?",
					List.of("HISTORIA"),
					OPTIONS,
					List.of("George Washington", "Thomas Jefferson", "John Adams"),
					"George Washington"
			);

			Question question16 = new Question(
					"¿Cuál es el animal terrestre más grande del mundo?",
					List.of("BIOLOGÍA"),
					OPTIONS,
					List.of("Elefante africano", "Ballena azul", "Girafa"),
					"Elefante africano"
			);

			Question question17 = new Question(
					"¿Quién fue el inventor de la bombilla eléctrica?",
					List.of("CIENCIA"),
					OPTIONS,
					List.of("Thomas Edison", "Nikola Tesla", "Alexander Graham Bell"),
					"Thomas Edison"
			);

			Question question18 = new Question(
					"¿Cuál es la montaña más alta del mundo?",
					List.of("GEOGRAFÍA"),
					OPTIONS,
					List.of("Monte Everest", "Monte Kilimanjaro", "Monte McKinley"),
					"Monte Everest"
			);

			Question question19 = new Question(
					"¿Cuál es el periodo de gestación promedio de un elefante?",
					List.of("BIOLOGÍA"),
					OPTIONS,
					List.of("12 meses", "18 meses", "24 meses"),
					"24 meses"
			);

			Question question20 = new Question(
					"¿Cuál es el país más grande del mundo por área?",
					List.of("GEOGRAFÍA"),
					OPTIONS,
					List.of("Rusia", "China", "Estados Unidos"),
					"Rusia"
			);

			Question question21 = new Question(
					"¿Cuál es el metal más abundante en la corteza terrestre?",
					List.of("QUÍMICA"),
					OPTIONS,
					List.of("Hierro", "Aluminio", "Cobre"),
					"Aluminio"
			);

			Question question22 = new Question(
					"¿En qué año se firmó la Declaración de Independencia de los Estados Unidos?",
					List.of("HISTORIA"),
					OPTIONS,
					List.of("1776", "1789", "1800"),
					"1776"
			);

			Question question23 = new Question(
					"¿Cuál es el compositor de la Novena Sinfonía?",
					List.of("MÚSICA"),
					OPTIONS,
					List.of("Ludwig van Beethoven", "Wolfgang Amadeus Mozart", "Johann Sebastian Bach"),
					"Ludwig van Beethoven"
			);

			Question question24 = new Question(
					"¿Cuántos huesos tiene el cuerpo humano adulto?",
					List.of("ANATOMÍA"),
					OPTIONS,
					List.of("206", "180", "230"),
					"206"
			);

			Question question25 = new Question(
					"¿Cuál es el instrumento principal en una orquesta sinfónica?",
					List.of("MÚSICA"),
					OPTIONS,
					List.of("Violín", "Piano", "Flauta"),
					"Violín"
			);

			Question question26 = new Question(
					"¿En qué continente se encuentra el desierto del Sahara?",
					List.of("GEOGRAFÍA"),
					OPTIONS,
					List.of("África", "Asia", "América del Sur"),
					"África"
			);

			Question question27 = new Question(
					"¿Cuál es el océano más profundo del mundo?",
					List.of("GEOGRAFÍA"),
					OPTIONS,
					List.of("Océano Pacífico", "Océano Atlántico", "Océano Índico"),
					"Océano Pacífico"
			);

			Question question28 = new Question(
					"¿Cuál es el mayor órgano del cuerpo humano?",
					List.of("ANATOMÍA"),
					OPTIONS,
					List.of("Hígado", "Piel", "Cerebro"),
					"Piel"
			);

			Question question29 = new Question(
					"¿Cuál es el planeta más grande de nuestro sistema solar?",
					List.of("CIENCIA"),
					OPTIONS,
					List.of("Júpiter", "Saturno", "Neptuno"),
					"Júpiter"
			);

			Question question30 = new Question(
					"¿Quién fue el fundador de Microsoft?",
					List.of("TECNOLOGÍA"),
					OPTIONS,
					List.of("Bill Gates", "Steve Jobs", "Mark Zuckerberg"),
					"Bill Gates"
			);

			Question question31 = new Question(
					"¿Cuál es la obra más famosa de Pablo Picasso?",
					List.of("ARTE"),
					OPTIONS,
					List.of("Guernica", "La Noche Estrellada", "La persistencia de la memoria"),
					"Guernica"
			);

			Question question32 = new Question(
					"¿En qué año se celebró la primera Copa Mundial de la FIFA?",
					List.of("DEPORTES"),
					OPTIONS,
					List.of("1930", "1950", "1962"),
					"1930"
			);

			Question question33 = new Question(
					"¿Cuál es el rango de pH del agua pura?",
					List.of("QUÍMICA"),
					OPTIONS,
					List.of("6-7", "7-8", "8-9"),
					"7"
			);

			Question question34 = new Question(
					"¿Cuál es la moneda oficial de Japón?",
					List.of("ECONOMÍA"),
					OPTIONS,
					List.of("Yen", "Dólar", "Euro"),
					"Yen"
			);

			Question question35 = new Question(
					"¿En qué año se llevó a cabo la Revolución Industrial?",
					List.of("HISTORIA"),
					OPTIONS,
					List.of("1760", "1840", "1900"),
					"1760"
			);

			Question question36 = new Question(
					"¿Cuál es el país más poblado del mundo?",
					List.of("GEOGRAFÍA"),
					OPTIONS,
					List.of("India", "China", "Estados Unidos"),
					"China"
			);

			Question question37 = new Question(
					"¿Quién fue el primer ser humano en llegar a la luna?",
					List.of("CIENCIA"),
					OPTIONS,
					List.of("Neil Armstrong", "Buzz Aldrin", "Yuri Gagarin"),
					"Neil Armstrong"
			);

			Question question38 = new Question(
					"¿Cuál es el metal más precioso?",
					List.of("QUÍMICA"),
					OPTIONS,
					List.of("Oro", "Plata", "Platino"),
					"Oro"
			);

			Question question39 = new Question(
					"¿Cuál es la capital de Italia?",
					List.of("CIUDADES"),
					OPTIONS,
					List.of("Madrid", "París", "Roma"),
					"Roma"
			);

			Question question40 = new Question(
					"¿En qué año se descubrió América?",
					List.of("HISTORIA"),
					OPTIONS,
					List.of("1492", "1500", "1520"),
					"1492"
			);

			Question question41 = new Question(
					"¿Cuál es el animal más veloz del mundo?",
					List.of("BIOLOGÍA"),
					OPTIONS,
					List.of("Cheetah", "Peregrine Falcon", "Pronghorn"),
					"Peregrine Falcon"
			);

			Question question42 = new Question(
					"¿Quién escribió '1984'?",
					List.of("LITERATURA"),
					OPTIONS,
					List.of("George Orwell", "Aldous Huxley", "Ray Bradbury"),
					"George Orwell"
			);

			Question question43 = new Question(
					"¿Cuál es el elemento más pesado de la tabla periódica?",
					List.of("QUÍMICA"),
					OPTIONS,
					List.of("Uranio", "Plutonio", "Osmio"),
					"Plutonio"
			);

			Question question44 = new Question(
					"¿En qué continente se encuentra Australia?",
					List.of("GEOGRAFÍA"),
					OPTIONS,
					List.of("Europa", "Asia", "Oceanía"),
					"Oceanía"
			);

			Question question45 = new Question(
					"¿Cuál es el equipo más laureado en la historia de la Liga de Campeones de la UEFA?",
					List.of("DEPORTES"),
					OPTIONS,
					List.of("Real Madrid", "FC Barcelona", "AC Milan"),
					"Real Madrid"
			);

			Question question46 = new Question(
					"¿Cuál es el río más largo de América del Sur?",
					List.of("GEOGRAFÍA"),
					OPTIONS,
					List.of("Amazonas", "Orinoco", "Paraná"),
					"Amazonas"
			);

			Question question47 = new Question(
					"¿Quién fue el pintor del famoso cuadro 'La Noche Estrellada'?",
					List.of("ARTE"),
					OPTIONS,
					List.of("Vincent van Gogh", "Pablo Picasso", "Claude Monet"),
					"Vincent van Gogh"
			);

			Question question48 = new Question(
					"¿En qué año se fundó la Organización de las Naciones Unidas (ONU)?",
					List.of("HISTORIA"),
					OPTIONS,
					List.of("1945", "1955", "1965"),
					"1945"
			);

			Question question49 = new Question(
					"¿Cuál es el desierto más grande del mundo?",
					List.of("GEOGRAFÍA"),
					OPTIONS,
					List.of("Sahara", "Atacama", "Antártico"),
					"Sahara"
			);

			Question question50 = new Question(
					"¿Cuál es el quinto planeta del sistema solar?",
					List.of("CIENCIA"),
					OPTIONS,
					List.of("Júpiter", "Marte", "Saturno"),
					"Júpiter"
			);

			Question question51 = new Question(
					"¿Cuál es el segundo planeta más cercano al sol?",
					List.of("CIENCIA"),
					OPTIONS,
					List.of("Venus", "Marte", "Júpiter", "Saturno"),
					"Venus"
			);

			Question question52 = new Question(
					"¿Quién escribió la obra 'Don Quijote de la Mancha'?",
					List.of("LITERATURA"),
					OPTIONS,
					List.of("Miguel de Cervantes", "Federico García Lorca", "Gabriel García Márquez", "Jorge Luis Borges"),
					"Miguel de Cervantes"
			);

			Question question53 = new Question(
					"¿Cuál es el proceso por el cual las plantas fabrican su propio alimento?",
					List.of("BIOLOGÍA"),
					OPTIONS,
					List.of("Fotosíntesis", "Respiración", "Transpiración", "Germinación"),
					"Fotosíntesis"
			);

			Question question54 = new Question(
					"¿En qué año se fundó la ciudad de Roma?",
					List.of("HISTORIA"),
					NUMERICAL,
					"753"
			);

			Question question55 = new Question(
					"¿Cuál es la capital de Canadá?",
					List.of("CIUDADES"),
					OPTIONS,
					List.of("Toronto", "Ottawa", "Vancouver", "Montreal"),
					"Ottawa"
			);

			Question question56 = new Question(
					"¿Cuál es el plato típico más representativo de Lambayeque?",
					List.of("CULTURA PERUANA"),
					OPTIONS,
					List.of("Ceviche", "Seco de Cabrito", "Arroz con Pato", "Sopa Teóloga"),
					"Sopa Teóloga"
			);

			Question question57 = new Question(
					"¿En qué año fue fundada la ciudad de Chiclayo, capital de Lambayeque?",
					List.of("HISTORIA PERUANA"),
					NUMERICAL,
					"1835"
			);

			Question question58 = new Question(
					"¿Cuál es el museo más destacado de Lambayeque, que alberga objetos de la cultura Moche?",
					List.of("CULTURA PERUANA"),
					OPTIONS,
					List.of("Museo Nacional de Arqueología", "Museo Tumbas Reales de Sipán", "Museo Larco", "Museo de Sitio Huaca Rajada"),
					"Museo Tumbas Reales de Sipán"
			);

			Question question59 = new Question(
					"¿Cuál es el baile tradicional más conocido en Lambayeque?",
					List.of("CULTURA PERUANA"),
					OPTIONS,
					List.of("Marinera", "Festejo", "Tondero", "Huayno"),
					"Tondero"
			);

			Question question60 = new Question(
					"¿Quién es considerado el héroe máximo de Lambayeque y luchó en la Batalla de Ayacucho?",
					List.of("HISTORIA PERUANA"),
					OPTIONS,
					List.of("Miguel Grau", "Francisco Bolognesi", "José Gálvez", "Ramón Castilla"),
					"Ramón Castilla"
			);

			Question question61 = new Question(
					"¿Cuál es la festividad religiosa más importante de Lambayeque?",
					List.of("CULTURA PERUANA"),
					OPTIONS,
					List.of("Semana Santa", "Fiesta de la Candelaria", "Fiesta de San Juan", "Fiesta de Santa Rosa de Lima"),
					"Fiesta de la Candelaria"
			);

			Question question62 = new Question(
					"¿Cuál es el nombre de la famosa pirámide truncada de la cultura Moche ubicada en Lambayeque?",
					List.of("ARQUEOLOGÍA PERUANA"),
					OPTIONS,
					List.of("Huaca de la Luna", "Huaca Rajada", "Huaca Pucllana", "Huaca El Brujo"),
					"Huaca de la Luna"
			);

			Question question63 = new Question(
					"¿Quién es el escritor lambayecano ganador del Premio Nobel de Literatura en 2010?",
					List.of("LITERATURA PERUANA"),
					OPTIONS,
					List.of("Mario Vargas Llosa", "Ciro Alegría", "Alfredo Bryce Echenique", "Santiago Roncagliolo"),
					"Mario Vargas Llosa"
			);

			Question question64 = new Question(
					"¿En qué año se produjo el descubrimiento de las Tumbas Reales de Sipán?",
					List.of("ARQUEOLOGÍA PERUANA"),
					NUMERICAL,
					"1987"
			);

			Question question65 = new Question(
					"¿Cuál es el río más importante que atraviesa Lambayeque?",
					List.of("GEOGRAFÍA PERUANA"),
					OPTIONS,
					List.of("Río Marañón", "Río Utcubamba", "Río Zaña", "Río Chancay"),
					"Río Zaña"
			);

			Question question66 = new Question(
					"¿Cuál es el plato típico de Lambayeque hecho a base de pescado?",
					List.of("CULTURA PERUANA"),
					OPTIONS,
					List.of("Chinguirito", "Causa Limeña", "Tacu Tacu", "Aji de Gallina"),
					"Chinguirito"
			);

			Question question67 = new Question(
					"¿Quién es el músico lambayecano conocido como el 'Rey del Sauce'?",
					List.of("MÚSICA PERUANA"),
					OPTIONS,
					List.of("Eva Ayllón", "Zambo Cavero", "Bartola", "Juaneco y su Combo"),
					"Juaneco y su Combo"
			);

			Question question68 = new Question(
					"¿Cuál es la bebida tradicional de Lambayeque elaborada a base de maíz morado?",
					List.of("CULTURA PERUANA"),
					OPTIONS,
					List.of("Chicha Morada", "Pisco Sour", "Inca Kola", "Mate de Coca"),
					"Chicha Morada"
			);

			Question question69 = new Question(
					"¿En qué mes se celebra la Feria Internacional del Libro de Chiclayo?",
					List.of("CULTURA PERUANA"),
					OPTIONS,
					List.of("Enero", "Abril", "Julio", "Octubre"),
					"Octubre"
			);

			Question question70 = new Question(
					"¿Cuál es la danza típica que representa la siembra y cosecha en Lambayeque?",
					List.of("DANZAS PERUANAS"),
					OPTIONS,
					List.of("Marinera", "Valicha", "Sarandonga", "Sikuri"),
					"Valicha"
			);

			Question question71 = new Question(
					"¿En qué año se fundó la Universidad Nacional Pedro Ruiz Gallo en Lambayeque?",
					List.of("EDUCACIÓN PERUANA"),
					NUMERICAL,
					"1962"
			);

			Question question72 = new Question(
					"¿Cuál es el nombre del complejo arqueológico situado en la ciudad de Lambayeque?",
					List.of("ARQUEOLOGÍA PERUANA"),
					OPTIONS,
					List.of("Túcume", "Chotuna", "Pómac Forest Historical Sanctuary", "Batan Grande"),
					"Túcume"
			);

			Question question73 = new Question(
					"¿Quién es la poetisa lambayecana conocida como la 'Flor de la Canela'?",
					List.of("LITERATURA PERUANA"),
					OPTIONS,
					List.of("César Vallejo", "José María Eguren", "Magda Portal", "Chabuca Granda"),
					"Chabuca Granda"
			);

			Question question74 = new Question(
					"¿Cuál es el monumento histórico ubicado en la Plaza de Armas de Chiclayo?",
					List.of("HISTORIA PERUANA"),
					OPTIONS,
					List.of("Catedral de Chiclayo", "Palacio Municipal", "Banco de la Nación", "Monumento a la Bandera"),
					"Catedral de Chiclayo"
			);

			Question question75 = new Question(
					"¿En qué año se creó la Región Lambayeque como entidad administrativa en el Perú?",
					List.of("GEOGRAFÍA PERUANA"),
					NUMERICAL,
					"1839"
			);

			List<Question> preguntas = List.of(
					question, question1, question2, question3, question4,
					question5, question6, question7, question8, question9,
					question10, question11, question12, question13, question14,
					question15, question16, question17, question18, question19,
					question20, question21, question22, question23, question24,
					question25, question26, question27, question28, question29,
					question30, question31, question32, question33, question34,
					question35, question36, question37, question38, question39,
					question40, question41, question42, question43, question44,
					question45, question46, question47, question48, question49,
					question50,question51,question52,question53,question54,question55,
					question56, question57, question58, question59, question60,
					question61, question62, question63, question64, question65,
					question66, question67, question68, question69, question70,
					question71, question72, question73, question74, question75
			);

			for (Question pregunta : preguntas) {
				questionService.save(pregunta);
			}

			List<Question> questions =List.of(question1,question3,question4,question6);

			Level level1 = new Level(
					"Level 1",
					1,
					List.of(question3, question4, question5, question6),
					"This is level 1.",
					true
			);

			Level level2 = new Level(
					"Level 2",
					2,
					List.of(question7, question8, question9, question10),
					"This is level 2.",
					false
			);

			Level level3 = new Level(
					"Level 3",
					3,
					List.of(question11, question12, question13, question14),
					"This is level 3.",
					false
			);

			Level level4 = new Level(
					"Level 4",
					4,
					List.of(question15, question16, question17, question18),
					"This is level 4.",
					false
			);

			Level level5 = new Level(
					"Level 5",
					5,
					List.of(question19, question20, question21, question22),
					"This is level 5.",
					false
			);

			Multiplayer multiplayer = new Multiplayer(
					List.of(user),
					List.of(question),
					List.of(2,3),
					user
			);

			Level level6 = new Level(
					"Level 6",
					6,
					List.of(question23, question24, question25, question26),
					"This is level 6.",
					false
			);

			Level level7 = new Level(
					"Level 7",
					7,
					List.of(question27, question28, question29, question30),
					"This is level 7.",
					false
			);

			Level level8 = new Level(
					"Level 8",
					8,
					List.of(question31, question32, question33, question34),
					"This is level 8.",
					false
			);

			Level level9 = new Level(
					"Level 9",
					9,
					List.of(question35, question36, question37, question38),
					"This is level 9.",
					false
			);

			Level level10 = new Level(
					"Level 10",
					10,
					List.of(question39, question40, question41, question42),
					"This is level 10.",
					false
			);

			Level level11 = new Level(
					"Level 11",
					11,
					List.of(question43, question44, question45, question46),
					"This is level 11.",
					false
			);

			Level level12 = new Level(
					"Level 12",
					12,
					List.of(question47, question48, question49, question50),
					"This is level 12.",
					false
			);

			Level level13 = new Level(
					"Level 13",
					13,
					List.of(question51, question52, question53, question54),
					"Este es el nivel 13.",
					false
			);

			Level level14 = new Level(
					"Level 14",
					14,
					List.of(question55, question56, question57, question58),
					"Este es el nivel 14.",
					false
			);

			Level level15 = new Level(
					"Level 15",
					15,
					List.of(question59, question60, question61, question62),
					"Este es el nivel 15.",
					false
			);

			Level level16 = new Level(
					"Level 16",
					16,
					List.of(question63, question64, question65, question66),
					"Este es el nivel 16.",
					false
			);

			Level level17 = new Level(
					"Level 17",
					17,
					List.of(question67, question68, question69, question70),
					"Este es el nivel 17.",
					false
			);

			Level level18 = new Level(
					"Level 18",
					18,
					List.of(question71, question72, question73, question74),
					"Este es el nivel 18.",
					false
			);

			List<Level> niveles = List.of(
					level1, level2, level3,level4,level5,level6,
					level7,level8,level9,level10,level11,level12,
					level13, level14, level15, level16, level17,
					level18
			);

			for (Level level: niveles) {
				levelService.save(level);
			}

			multiplayerService.save(multiplayer);
		};
	}
}
