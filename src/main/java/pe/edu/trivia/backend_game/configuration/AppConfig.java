package pe.edu.trivia.backend_game.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CorsConfig.class)
public class AppConfig {
    // Otras configuraciones de la aplicación
}
