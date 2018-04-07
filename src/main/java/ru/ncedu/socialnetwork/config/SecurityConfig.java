package ru.ncedu.socialnetwork.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.client.RestTemplate;
import ru.ncedu.socialnetwork.api.models.UserDAO;
import ru.ncedu.socialnetwork.api.services.UserService;

import javax.servlet.Filter;

@Configuration
@EnableOAuth2Client
@Profile("!review")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final OAuth2ClientContext oauth2ClientContext;
    private UserService userService;

    @Autowired
    public SecurityConfig(@Qualifier("oauth2ClientContext") final OAuth2ClientContext oauth2ClientContext,
                          UserService userService) {
        this.oauth2ClientContext = oauth2ClientContext;
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers( "/", "/login", "/api/user", "/index.html", "/app.js", "/static/**", "/h2-console/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().logout()
                .logoutSuccessUrl("/")
                .permitAll()
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and().addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);

    }

    @Bean
    @ConfigurationProperties("github.client")
    public AuthorizationCodeResourceDetails github() {
        return new AuthorizationCodeResourceDetails();
    }

    @Bean
    @ConfigurationProperties("github.resource")
    public ResourceServerProperties githubResource() {
        return new ResourceServerProperties();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new OAuth2RestTemplate(github(), oauth2ClientContext);
    }

    private Filter ssoFilter() {
        OAuth2ClientAuthenticationProcessingFilter githubFilter = new OAuth2ClientAuthenticationProcessingFilter("/login");
        OAuth2RestTemplate githubTemplate = (OAuth2RestTemplate) restTemplate();
        githubFilter.setRestTemplate(githubTemplate);
        UserInfoTokenServices tokenServices = new UserInfoTokenServices(githubResource().getUserInfoUri(), github().getClientId());
        tokenServices = new UserInfoTokenServices(githubResource().getUserInfoUri(), github().getClientId());
        tokenServices.setRestTemplate(githubTemplate);
        githubFilter.setTokenServices(tokenServices);
        return githubFilter;
    }

    @Bean
    public FilterRegistrationBean oauth2ClientFilterRegistration(
            OAuth2ClientContextFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setOrder(-100);
        return registration;
    }

    @Bean
    public PrincipalExtractor principalExtractor(UserService userService) {
        return map -> {
            String login = (String) map.get("login");
            UserDAO user = userService.findByLogin(login);
            if (user == null) {
                user = new UserDAO(login);
            }
            userService.saveUser(user);
            return user;
        };
    }
}

