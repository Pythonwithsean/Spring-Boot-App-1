package com.seanapi.example;

import org.apache.catalina.authenticator.FormAuthenticator;
import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    // This allows for filtered pages to be access by user
    @Bean
    protected SecurityFilterChain filter(HttpSecurity http) throws Exception {
        /**
         * 
         * authorizeHttpRequests(auth ->
         * (auth.requestMatchers("/home").permitAll()).anyRequest().authenticated())
         * .formLogin(Customizer.withDefaults());
         */

        http.authorizeHttpRequests(req -> req.anyRequest().authenticated()).formLogin(form -> {
            form.loginPage("/login").defaultSuccessUrl("/home", true).permitAll();
        });
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager Auth() {
        PasswordEncoder pe = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails admin = User.withUsername("ADMIN").password(pe.encode("ADMIN")).roles("admin").build();
        return new InMemoryUserDetailsManager(admin);
    }

}
