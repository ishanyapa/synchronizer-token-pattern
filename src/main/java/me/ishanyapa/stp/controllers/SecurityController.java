package me.ishanyapa.stp.controllers;

import me.ishanyapa.stp.services.SessionService;
import me.ishanyapa.stp.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class SecurityController {

    @Autowired
    TokenService tokenService;

    @Autowired
    SessionService sessionService;

    @GetMapping(value= "/csrf", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getCsrfToken(HttpServletRequest request) {

        String sessionId;
        String token = "";

        if (request.getSession(false).getId() != null) {
            sessionId = request.getSession(false).getId();
            token = tokenService.generateNewToken();
            sessionService.addSession(sessionId, token);
        }

        return token;
    }
}
