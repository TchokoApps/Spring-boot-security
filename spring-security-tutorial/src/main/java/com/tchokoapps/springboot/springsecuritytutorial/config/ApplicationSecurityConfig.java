package com.tchokoapps.springboot.springsecuritytutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.tchokoapps.springboot.springsecuritytutorial.config.ApplicationUserRoles.ADMIN;
import static com.tchokoapps.springboot.springsecuritytutorial.config.ApplicationUserRoles.STUDENT;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails studentUserDetails = User.builder()
                .username("user")
                .password(passwordEncoder.encode("1"))
                .roles(STUDENT.name())
                .build();

        UserDetails adminUserDetails = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("1"))
                .roles(STUDENT.name(), ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(studentUserDetails, adminUserDetails);
    }
}
