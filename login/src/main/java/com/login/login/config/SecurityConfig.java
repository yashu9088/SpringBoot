package com.login.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/signup", "/css/**", "/js/**", "/").permitAll()
                        .requestMatchers("/users").authenticated()
                        .requestMatchers("/add-keypoint", "/my-keypoints").authenticated()
                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                )

                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                );

        return http.build();
    }
}
































//
//
//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//    http
//            .csrf(csrf -> csrf.disable())
//
//            .authorizeHttpRequests(auth -> auth
//                    .requestMatchers("/login").permitAll()
//                    .anyRequest().authenticated()
//            )
//
//            .formLogin(form -> form
//                    .loginPage("/login")
//                    .defaultSuccessUrl("/home", true)
//            )
//
//            .logout(logout -> logout
//                    .logoutSuccessUrl("/login?logout")
//            );
//
//    return http.build();
//}
//
//@Bean
//public UserDetailsService userDetailsService() {
//    UserDetails user = User.withUsername("admin").password("{noop}admin123").roles("USER").build();
//    return new InMemoryUserDetailsManager(user);
//}