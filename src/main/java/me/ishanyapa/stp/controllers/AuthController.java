package me.ishanyapa.stp.controllers;

import me.ishanyapa.stp.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/api")
public class AuthController {

    @Autowired
    SessionService sessionService;

    @PostMapping(value= "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void login(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (String.valueOf(email).equals("ishanyapa@gmail.com") && String.valueOf(password).equals("123")) {

            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute("username", "ishan");
            sessionService.addSession(request.getSession(false).getId(), "123");
            response.sendRedirect("/control.html");
            return;
        }

        response.sendRedirect("/index.html");
    }
}
