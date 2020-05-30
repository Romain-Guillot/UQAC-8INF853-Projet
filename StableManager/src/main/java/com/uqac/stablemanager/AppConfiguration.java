package com.uqac.stablemanager;

import com.uqac.stablemanager.auth.service.AuthenticationService;
import com.uqac.stablemanager.utils.MySQLConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().antMatchers("/auth/login*").anonymous().and()
                .authorizeRequests().antMatchers("/auth/perform_login*").anonymous().and()
                .authorizeRequests().anyRequest().authenticated().and()
                .formLogin()
                    .loginPage("/auth/login")
                    .loginProcessingUrl("/auth/perform_login")
                    .defaultSuccessUrl("/index")
                    .failureUrl("/auth/login?error")
                    .usernameParameter("email").passwordParameter("password");

        http.logout()
                .logoutUrl("/auth/perform_logout")
                .logoutSuccessUrl("/auth/login");
    }

    @Bean
    public AuthenticationService authenticationService() {
        return new AuthenticationService(MySQLConnection.getConnection());
    }
}
