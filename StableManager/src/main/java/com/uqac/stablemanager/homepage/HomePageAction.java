package com.uqac.stablemanager.homepage;

import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.security.service.IRoleService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Action pour fournir les données nécessaires à afficher sur la page d'accueil du site
 *
 * Pour l'instant, seuls les rôles ont besoin d'être founris à la page d'accueil, le reste étant
 * des liens direct vers des actions qui ne requière par de paramètre particulier.
 */
public class HomePageAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired
    private IRoleService roleService;
    private List<RoleModel> roles;

    @Override
    public String execute() {
        try {
            roles = roleService.list();
        } catch (Exception e) {}
        return SUCCESS;
    }

    public List<RoleModel> getRoles() {
        return roles;
    }
}
