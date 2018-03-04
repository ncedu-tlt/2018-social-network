package ru.ncedu.socialnetwork.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
@Profile("!review")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();  // todo: logout need CSRF token
        //http.cors().disable();
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

