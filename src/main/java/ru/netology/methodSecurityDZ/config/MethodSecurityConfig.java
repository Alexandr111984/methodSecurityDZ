package ru.netology.methodSecurityDZ.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import ru.netology.methodSecurityDZ.service.PersonsService;

@Getter
@Configuration
@EnableWebSecurity

public class MethodSecurityConfig {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .and()
//                .authorizeRequests().antMatchers("/persons/**").authenticated()
//                .and()
//                .authorizeRequests().antMatchers("/persons/by").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/persons/by-age").hasAuthority("/persons/by-age")
//                .and()
//                .authorizeRequests().anyRequest().authenticated();
//
//    }

    @Bean

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                .anyRequest().authenticated());
        http.headers(Customizer.withDefaults());
        http.sessionManagement(Customizer.withDefaults());
        http.formLogin(AbstractAuthenticationFilterConfigurer::permitAll);
        http.anonymous(Customizer.withDefaults());
        //noinspection removal
        http.csrf().disable();
        return http.build();
    }

    @Bean
    public UserDetailsService InMemoryUserDetailsService(PasswordEncoder passwordEncoder) {
        User.UserBuilder users = User.builder()
                .passwordEncoder(passwordEncoder::encode);
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(users.username("admin")
                .password("admin")
                .roles("READ")
                .build());
        userDetailsManager.createUser(users.username("user")
                .password("user")
                .roles("READ")
                .build());
        userDetailsManager.createUser(users.username("alex")
                .password("alex")
                .roles("DELETE")
                .build());
        userDetailsManager.createUser(users.username("Alexey")
                .password("123")
                .build());
        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
