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
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;




@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


    //This allows for filtered pages to be access by user 
    @Bean
    protected SecurityFilterChain filter(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests( auth -> (auth.requestMatchers("/home").permitAll()).anyRequest().authenticated()).formLogin(Customizer.withDefaults());
        return http.build();
    }

    

    



    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails UserDetails = User.withUsername("user").password("password").roles("user").build();
        String pass = UserDetails.getPassword();
        System.out.println(pass);
        return new InMemoryUserDetailsManager(UserDetails);
    }

 

}
