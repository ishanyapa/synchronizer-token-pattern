package me.ishanyapa.stp.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class SessionService {

    private static HashMap<String, String> sessionStorage;

    public void addSession(String sessionId, String csrf) {

        if (sessionStorage == null) {
            sessionStorage = new HashMap<>();
        }

        sessionStorage.put(sessionId, csrf);
    }

    public String getCsrf (String sessionId) {

        if (sessionStorage != null) {

            if (sessionStorage.get(sessionId) != null) {
                return sessionStorage.get(sessionId);
            }

            return "NULL";
        }

        return "NULL";
    }

    public void removeCsrf (String sessionId) {

        if (sessionStorage.get(sessionId) != null) {
            sessionStorage.remove(sessionId);
        }
    }
}
