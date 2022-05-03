package com.relive.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceServerTestController {

    @GetMapping("/resource/test")
    public String getArticles(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Resource accessed by %s (sub)", jwt.getSubject());
    }
}
