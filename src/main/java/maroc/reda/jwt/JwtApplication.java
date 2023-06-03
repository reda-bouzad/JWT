package maroc.reda.jwt;

import maroc.reda.jwt.auth.AuthenticationService;
import maroc.reda.jwt.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static maroc.reda.jwt.myenums.Roles.ADMIN;
import static maroc.reda.jwt.myenums.Roles.MANAGER;

@SpringBootApplication
public class JwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }


}
