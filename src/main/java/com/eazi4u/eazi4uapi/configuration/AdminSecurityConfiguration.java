package com.eazi4u.eazi4uapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

@Configuration
@Order(2)
public class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .headers()
                .disable()
                .antMatcher("/users/**")
                .addFilter(getDigestAuthFilter())
                .exceptionHandling()
                .authenticationEntryPoint(getDigestEntryPoint())
                .and()
                .authorizeRequests()
                .antMatchers("/users/**")
                .hasRole("ADMIN");
    }

    private DigestAuthenticationFilter getDigestAuthFilter() throws Exception {
        DigestAuthenticationFilter digestFilter = new DigestAuthenticationFilter();
        digestFilter.setUserDetailsService(userDetailsServiceBean());
        digestFilter.setAuthenticationEntryPoint(getDigestEntryPoint());
        digestFilter.setPasswordAlreadyEncoded(true);
        digestFilter.setCreateAuthenticatedToken(true);
        return digestFilter;
    }

    private DigestAuthenticationEntryPoint getDigestEntryPoint() {
        DigestAuthenticationEntryPoint digestEntryPoint = new DigestAuthenticationEntryPoint();
        digestEntryPoint.setRealmName("admin-digest-realm");
        digestEntryPoint.setKey("fjkaidkjlkjd_+");
        return digestEntryPoint;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                    .password("password")
                    .roles("USER")
            .and()
                .withUser("admin")
                    .password("password11")
                    .roles("ADMIN");
    }

    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
