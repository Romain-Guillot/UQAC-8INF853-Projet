package com.uqac.stablemanager;

import com.uqac.stablemanager.auth.service.IAuthenticationService;
import com.uqac.stablemanager.auth.service.SpringSecurityAuthenticationService;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.security.service.PermissionService;
import com.uqac.stablemanager.security.service.RoleService;
import com.uqac.stablemanager.utils.MySQLConnection;
import com.uqac.stablemanager.utils.PasswordManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.sql.Connection;
import java.text.SimpleDateFormat;

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
    public IAuthenticationService authenticationService() {
        return new SpringSecurityAuthenticationService();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService();
    }

    @Bean
    public RoleService roleService() {
        return new RoleService();
    }

    @Bean
    public PasswordManager passwordManager() {
        return new PasswordManager(12);
    }

    @Bean
    public PermissionService permissionService() {
        return new PermissionService();
    }

    @Bean
    public HorseService horseService() {
        return new HorseService();
    }

    @Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("dd/MM/yyyy");
    }
}
