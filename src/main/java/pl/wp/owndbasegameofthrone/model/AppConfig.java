package pl.wp.owndbasegameofthrone.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wp.owndbasegameofthrone.sourceConnection.BookAPIHandler;

@Configuration
public class AppConfig {

    @Bean
    public BookAPIHandler defautlBookAPIHandler() {
        return new BookAPIHandler();
    }
}
