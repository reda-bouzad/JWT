package maroc.reda.jwt.Security;

import lombok.RequiredArgsConstructor;
import maroc.reda.jwt.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor

public class ApplicationConfig {

    private final UserDao userDao;
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userDao.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
