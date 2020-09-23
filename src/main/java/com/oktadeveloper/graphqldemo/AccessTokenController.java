package com.oktadeveloper.graphqldemo;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
class AccessTokenController {

    private final OAuth2AuthorizedClientService clientService;

    public AccessTokenController(OAuth2AuthorizedClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/")
    String getTokenValue(Principal user) {

        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) user;
        String authorizedClientRegistrationId = token.getAuthorizedClientRegistrationId();
        String name = user.getName();
        OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(authorizedClientRegistrationId, name);

        return client.getAccessToken().getTokenValue();
    }

}
