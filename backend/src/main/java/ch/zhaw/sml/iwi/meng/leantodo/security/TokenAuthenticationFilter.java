package ch.zhaw.sml.iwi.meng.leantodo.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class TokenAuthenticationFilter extends GenericFilterBean {

    public static final Logger LOGGER = LoggerFactory.getLogger(TokenAuthenticationFilter.class);

    private String secret;

    public TokenAuthenticationFilter(String secret) {

        this.secret = secret;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Cookie tokenCookie = null;

        if (!(request instanceof HttpServletRequest)) {
            // We only handle http requests here.
            // Hand off the request to the rest of the filter chain.
            chain.doFilter(request, response);
            return;
        }
        HttpServletRequest httprequest = (HttpServletRequest) request;
        
        Cookie[] cookies = httprequest.getCookies();

        if (cookies == null || cookies.length < 1) {
            LOGGER.debug("No cookies for authentication present!");
            // Hand off the request to the rest of the filter chain.
            chain.doFilter(request, response);
            return;
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("Authentication")) {
                tokenCookie = cookie;
                break;
            }
        }

        if (tokenCookie == null || tokenCookie.getValue() == null || tokenCookie.getValue().length() == 0) {
            LOGGER.debug("No valid cookies for authentication found!");
            // Hand off the request to the rest of the filter chain.
            chain.doFilter(request, response);
            return;

        }
        String rawJsonWebToken = tokenCookie.getValue();
        if (!Jwts.parser().setSigningKey(secret).isSigned(rawJsonWebToken)) {
            LOGGER.debug("Token not signed and therefore not trustworthy!");
            // We can stop here and abort the request. An attempt was made to log in with an
            // unsigned token.
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token is invalid!");
        }

        try {
            Jws<Claims> jws = Jwts.parser().setSigningKey(secret).parseClaimsJws(rawJsonWebToken);

            // If we get here without exception, we know that the token is valid, signed and
            // has not expired. Hence, we trust it.
            Authentication authentication = new JwtAuthentication(jws);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        } catch (Exception e) {
            LOGGER.info("Token could not be parsed!");
            // We can stop here and abort the request. An attempt was made to log in with an
            // invalid token.
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token is invalid!");
        }
    }

}