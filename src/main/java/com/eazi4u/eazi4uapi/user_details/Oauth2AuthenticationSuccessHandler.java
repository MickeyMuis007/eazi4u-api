package com.eazi4u.eazi4uapi.user_details;

import com.eazi4u.eazi4uapi.model.user.User;
import com.eazi4u.eazi4uapi.model.user.UserBuilder;
import com.eazi4u.eazi4uapi.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component("oauth2authSuccessHandler")
public class Oauth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private IUserRepository userRepository;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("Success handler");
        if (authentication instanceof OAuth2AuthenticationToken) {
            OAuth2AuthenticationToken oToken = (OAuth2AuthenticationToken)authentication;
            String name = oToken.getPrincipal().getAttributes().get("name").toString();
            String email = oToken.getPrincipal().getAttributes().get("email").toString();

            UserBuilder userBuilder = UserBuilder.getInstance();
            User user = userBuilder.name(name).email(email).enabled(true).build();

            try {
                List<User> users = userRepository.findAll();
                List<User> result = users.stream()
                        .filter(a -> Objects.equals(a.getEmail(), email))
                        .collect(Collectors.toList());
                if (result.isEmpty())
                    userRepository.save(user);
                redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/");
            }
            catch(Exception e) {
                System.out.println("Failed");
            }
        }
    }
}
