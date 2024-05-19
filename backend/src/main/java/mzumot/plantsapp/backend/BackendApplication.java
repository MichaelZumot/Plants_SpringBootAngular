package mzumot.plantsapp.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.cors.CorsConfiguration;

@SpringBootApplication
@ComponentScan("mzumot.plantsapp.backend.corsConfig")
@ComponentScan("mzumot.plantsapp.backend.repository")
@EntityScan("mzumot.plantsapp.backend.model")
@Import(CorsConfiguration.class)

public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

}
