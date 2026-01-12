package com.hardik.gateway;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GateController {

    @GetMapping("/")
    String hello(){
        return "Hello World";
    }

    @GetMapping("/auth")
    String authEndpoint(Authentication authentication){
        IO.println(authentication);
        return "Hello: " + getEmail(authentication) ;
    }

    private String getEmail(Authentication authentication){
        return Optional.of(authentication)
                .filter(OAuth2AuthenticationToken.class::isInstance)
                .map(OAuth2AuthenticationToken.class::cast)
                .map(OAuth2AuthenticationToken::getPrincipal)
                .map(OidcUser.class::cast)
                .map(OidcUser::getEmail)
                .orElse(authentication.getName());
    }
}
