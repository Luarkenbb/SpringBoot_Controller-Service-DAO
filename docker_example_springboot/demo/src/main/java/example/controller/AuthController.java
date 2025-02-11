package example.controller;

import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.annotation.annotations.Syslog;
import example.service.KeycloakService;

@RestController
@RequestMapping("${keycloak.publicUrl}/auth")
public class AuthController {

    @Autowired
    private KeycloakService keycloakService;

    @Syslog
    @PostMapping("/login")
    public ResponseEntity<AccessTokenResponse> login(@RequestBody LoginRequest loginRequest) {
        AccessTokenResponse tokenResponse = keycloakService.login(loginRequest.getUsername(), loginRequest.getPassword());
        return ResponseEntity.ok(tokenResponse);
    }

    public static class LoginRequest {
        private String username;
        private String password;

        // Getters and Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
