package me.ishanyapa.stp.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecurityController {

    @GetMapping(value= "/csrf", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getCsrfToken() {
        return "123";
    }
}
