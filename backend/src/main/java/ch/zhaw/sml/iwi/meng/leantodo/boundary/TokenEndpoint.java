package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.sml.iwi.meng.leantodo.security.TokenGenerator;
import ch.zhaw.sml.iwi.meng.leantodo.security.UserAuthResponse;

@RestController
public class TokenEndpoint {

    @Autowired
    private TokenGenerator tokenGenerator;

    @RequestMapping(path = "/auth/token", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public UserAuthResponse token(Principal principal, HttpServletResponse response) {
        return createTokenSetCookie(principal,response);
    }

    // The same functionality as '/auth/token' but authenticated by token instead of basic security
    @RequestMapping(path = "/auth/refresh", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public UserAuthResponse refresh(Principal principal, HttpServletResponse response) {
        return createTokenSetCookie(principal,response);
    }

    // If logout is desired, we replace the client token without content and set its expiration time to 0
    @RequestMapping(path = "/auth/logout", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public void logout(Principal principal, HttpServletResponse response) {
        Cookie cookie = new Cookie("Authentication", null);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    private UserAuthResponse createTokenSetCookie(Principal principal, HttpServletResponse response) {
        String username = principal.getName();
        UserAuthResponse userAuthResponse = tokenGenerator.generateJWT(username);
        Cookie cookie = new Cookie("Authentication", userAuthResponse.getJwsToken());
        
        // This is essential! It must be HTTP-Only, otherwise it can be accessed by JavaScript
        cookie.setHttpOnly(true);

        cookie.setPath("/");
        cookie.setMaxAge(3600);

        response.addCookie(cookie);

        return userAuthResponse;

    }

}