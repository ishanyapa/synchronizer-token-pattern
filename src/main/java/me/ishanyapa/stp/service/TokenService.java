package me.ishanyapa.stp.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenService {

    public String generateNewToken() {
        return UUID.randomUUID().toString();
    }
}
