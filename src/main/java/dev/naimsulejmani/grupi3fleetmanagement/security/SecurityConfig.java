package dev.naimsulejmani.grupi3fleetmanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    // e krijon nje objekt te tipit PasswordEncoder (BCryptPasswordEncoder) qe do te perdoret per enkriptimin e passwordit
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
//var securityConfig = new SecurityConfig()
// var passwordEncoder = securityConfig.passwordEncoder()