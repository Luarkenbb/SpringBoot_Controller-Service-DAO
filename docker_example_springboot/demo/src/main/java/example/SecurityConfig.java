package example;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults()); // Enable CORS
        http.csrf(csrf -> csrf.disable());// Disable CSRF

        http
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests // Require all requests to be authorized
                .anyRequest().permitAll()
            ); 

        return http.build();
    }
    
}