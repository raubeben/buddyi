package ch.zhaw.sml.iwi.meng.leantodo.security.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ch.zhaw.sml.iwi.meng.leantodo.security.TokenAuthenticationFilter;


@Configuration
@Order(1)
public class TokenCookieAuthSecurityConfigAPI extends WebSecurityConfigurerAdapter {
   
    @Value("${jwt.secret}")
    private String secret;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.antMatcher("/api/**")
                .addFilterBefore(new TokenAuthenticationFilter(secret), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .httpBasic().disable()
                .authorizeRequests()
                    .antMatchers(HttpMethod.OPTIONS,"/api/**").permitAll()
                .anyRequest().authenticated();        
    }   
    
   
}