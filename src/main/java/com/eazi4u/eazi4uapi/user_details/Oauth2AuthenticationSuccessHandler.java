package com.eazi4u.eazi4uapi.user_details;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("oauth2authSuccessHandler")
public class Oauth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("Success handler");
        if (authentication instanceof OAuth2AuthenticationToken) {
            OAuth2AuthenticationToken oToken = (OAuth2AuthenticationToken)authentication;
            String name = oToken.getPrincipal().getAttributes().get("name").toString();
            String email = oToken.getPrincipal().getAttributes().get("email").toString();
        }
    }
}
