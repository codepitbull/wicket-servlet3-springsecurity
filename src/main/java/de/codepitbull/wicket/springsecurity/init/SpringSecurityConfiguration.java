package de.codepitbull.wicket.springsecurity.init;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Jochen Mader
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeUrls()
                .antMatchers("/favicon.ico")
                    .permitAll()
                .antMatchers("/**")
                    .hasRole("USER")
                    .and()
                    .formLogin()
                        .loginPage("/login")
                        .permitAll();
    }

    @Override
    protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("testuser")
                    .password("password")
                    .roles("USER");
    }
}
