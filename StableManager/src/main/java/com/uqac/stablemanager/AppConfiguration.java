package com.uqac.stablemanager;

import com.uqac.stablemanager.auth.service.IAuthenticationService;
import com.uqac.stablemanager.auth.service.SpringSecurityAuthenticationService;
import com.uqac.stablemanager.booking.model.BookingModel;
import com.uqac.stablemanager.booking.service.IBookingService;
import com.uqac.stablemanager.booking.service.SQLBookingBuilder;
import com.uqac.stablemanager.booking.service.SQLBookingDestructor;
import com.uqac.stablemanager.booking.service.SQLBookingService;
import com.uqac.stablemanager.equipment.service.EquipmentService;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.*;
import com.uqac.stablemanager.security.service.PermissionService;
import com.uqac.stablemanager.security.service.RoleService;
import com.uqac.stablemanager.utils.PasswordManager;
import com.uqac.stablemanager.utils.sql.SQLModelBuilder;
import com.uqac.stablemanager.utils.sql.SQLModelDestructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.text.SimpleDateFormat;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, proxyTargetClass = true, jsr250Enabled = true)
public class AppConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().antMatchers("/auth/login*").anonymous().and()
                .authorizeRequests().antMatchers("/auth/perform_login*").anonymous().and()
                .authorizeRequests().antMatchers("/assets/**").permitAll().and()
                .authorizeRequests().anyRequest().authenticated().and()
                .exceptionHandling().accessDeniedPage("/error/err403.jsp").and()
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
    public IMemberService memberService() {
        return new SQLMemberService();
    }

    @Bean
    public SQLModelBuilder<MemberModel> memberBuilder() {
        return new SQLMemberBuilder();
    }

    @Bean
    public SQLModelDestructor<MemberModel> memberDestructor() {
        return new SQLMemberDestructor();
    }

    @Bean
    public IBookingService bookingService() {
        return new SQLBookingService();
    }

    @Bean
    public SQLModelBuilder<BookingModel> bookingBuilder() {
        return new SQLBookingBuilder();
    }

    @Bean
    public SQLModelDestructor<BookingModel> bookingDestructor() {
        return new SQLBookingDestructor();
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
    public EquipmentService equipmentService() {
        return new EquipmentService();
    }

    @Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("dd/MM/yyyy");
    }

    @Bean
    public MemberControlBasedService controlBasedService() {
        return new MemberControlBasedService();
    }
}
