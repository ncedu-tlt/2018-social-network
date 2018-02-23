package ru.ncedu.socialnetwork.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Profile("!review")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
            .authorizeRequests()
                .antMatchers("/", "/login", "/index.html", "/app.js", "/static/**", "/h2-console/**")
                .permitAll()
            .anyRequest()
                .authenticated()
            .and().logout()
                .logoutSuccessUrl("/")
                .permitAll();
    }
}
