package com.uqac.stablemanager.auth.service;

import com.uqac.stablemanager.auth.model.CredentialsModel;
import com.uqac.stablemanager.member.service.MemberService;
import org.apache.struts2.ServletActionContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class AuthenticationService {
    /**
     *
     */
    private final Connection connection;

    /**
     *
     * @param connection
     */
    public AuthenticationService(Connection connection) {
        this.connection = connection;
    }

    /**
     *
     * @param credentials
     * @return
     */
    public boolean login(CredentialsModel credentials) {
        boolean isAuthenticated = false;
        try {
            String query = "SELECT passwd FROM ProfileMember WHERE email=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, credentials.getEmail());
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                String hashPass = result.getString("passwd");
                String plainPass = credentials.getPassword();
                boolean passwordMatches = BCrypt.checkpw(plainPass, hashPass);
                if (passwordMatches) {
                    UserDetails user = new MemberService(connection).findByEmail(credentials.getEmail());
                    setSpringAuthentication(user);
                    isAuthenticated = true;
                }
            }
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return isAuthenticated;
    }

    /**
     *
     */
    public void logout() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(ServletActionContext.getRequest(), ServletActionContext.getResponse(), auth);
        }
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    /**
     *
     * @param user
     */
    private void setSpringAuthentication(UserDetails user) {
        Authentication auth = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
