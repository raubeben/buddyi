package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.sml.iwi.meng.leantodo.controller.UserController;
import ch.zhaw.sml.iwi.meng.leantodo.entity.User;

@RestController
public class UserEndpoint {

    @Autowired
    private UserController userController;

    @RequestMapping(path = "/api/me", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public User me(Principal principal) {
        return userController.getInformations(principal.getName());
    }

    @RequestMapping(path = "/api/{user}", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public User lookForOtherUser (@PathVariable (name = "user") String benutzername){
        return userController.getInformations(benutzername);
    }

}