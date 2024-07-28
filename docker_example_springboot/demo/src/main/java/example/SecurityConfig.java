package example;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Value("${keycloak.auth-server-url}")
    private String keycloakAuthServerUrl;

    @Value("${keycloak.realm}")
    private String keycloakRealm;

    @Value("${keycloak.resource}")
    private String clientId;

    @Value("${keycloak.credentials.secret}")
    private String clientSecret;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults()); // Enable CORS
        http.csrf(csrf -> csrf.disable());// Disable CSRF

        http
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests // Require all requests to be authorized
                .anyRequest().permitAll()
            ); // Allow all requests

            /*
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests // Require all requests to be authorized
                .anyRequest().authenticated()
            ) // Allow all requests
            .oauth2Login(oauth2Login -> oauth2Login
                .loginPage("/oauth2/authorization/keycloak")
            )
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults())); // Enable OAuth2 login
            */

        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        String jwkSetUri = String.format("%s/realms/%s/protocol/openid-connect/certs", keycloakAuthServerUrl, keycloakRealm);
        return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
    }

    
}