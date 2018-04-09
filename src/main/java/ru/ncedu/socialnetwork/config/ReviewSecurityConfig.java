package ru.ncedu.socialnetwork.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import ru.ncedu.socialnetwork.repositories.UserRepository;

@Configuration
@EnableOAuth2Client
@Profile("review")
public class ReviewSecurityConfig extends SecurityConfig {

    @Autowired
    public ReviewSecurityConfig(@Qualifier("oauth2ClientContext") OAuth2ClientContext oauth2ClientContext, UserRepository userRepository) {
        super(oauth2ClientContext, userRepository);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
