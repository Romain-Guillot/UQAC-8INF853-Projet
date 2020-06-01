package com.uqac.stablemanager.auth.service;

import com.uqac.stablemanager.auth.model.CredentialsModel;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.utils.PasswordManager;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import java.lang.reflect.Member;
import java.util.Map;

/**
 * {@inheritDoc}
 *
 * Implémente le système d'authentification avec Spring Security.
 */
public class SpringSecurityAuthenticationService implements IAuthenticationService {
    @Autowired private MemberService memberService;
    @Autowired private PasswordManager passwordManager;


    /**
     * {@inheritDoc}
     *
     * Récupère l'utilisateur correspondant à l'email renseigné et vérifie si le mot de passe
     * fourni et celui enregistré en BDD correspondent.
     *
     * Le chiffrement du mot de passe est opéré par la classe [PasswordManager]
     */
    @Override
    public boolean login(CredentialsModel credentials) {
        boolean isAuthenticated = false;
        UserDetails user = memberService.findByEmail(credentials.getEmail());
        if (user != null) {
            String hashPass = user.getPassword();
            String plainPass = credentials.getPassword();
            boolean passwordsMatch = passwordManager.check(plainPass, hashPass);
            if (passwordsMatch) {
                setSpringAuthentication(user);
                isAuthenticated = true;
            }
        }
        return isAuthenticated;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void logout() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(ServletActionContext.getRequest(), ServletActionContext.getResponse(), auth);
        }
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    /**
     * {@inheritDoc}
     * Retrouve l'utilisateur dans la session courrante
     */
    @Override
    public MemberModel getConnectedMember(Map<String, Object> sessionObject) {
        MemberModel member = (MemberModel) ((SecurityContextImpl) sessionObject.get("SPRING_SECURITY_CONTEXT")).getAuthentication().getPrincipal();
        if (member == null) {
            logout();
        }
        return member;
    }

    /**
     * Assure la connexion d'un utilisateur [user] avec Spring Security
     * @param user l'utilisateur à authentifier avec Spring Secuirty
     */
    private void setSpringAuthentication(UserDetails user) {
        Authentication auth = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
