
package com.livingvoices.transcriptionservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WhoAmIController {

    @Value("${spring.application.name}")
    private String service;

    @GetMapping("whoami")
    Map<String, Object> whoAmI(@AuthenticationPrincipal Jwt jwt) {
        return Map.of(
                "service", service,
                "user", jwt.getClaimAsString("preferred_username"),
                "roles", jwt.getClaimAsStringList("roles"));
    }
}
