package pl.wp.owndbasegameofthrone.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wp.owndbasegameofthrone.service.CharacterService;
import pl.wp.owndbasegameofthrone.sourceConnection.BookAPIHandler;
import pl.wp.owndbasegameofthrone.sourceConnection.CharacterAPIHandler;

@Configuration
public class AppConfig {

    @Bean
    public BookAPIHandler defautlBookAPIHandler() {
        return new BookAPIHandler();
    }
    @Bean
    public CharacterAPIHandler defaultCharacterAPIHandler() {
        return new CharacterAPIHandler();
    }
}
