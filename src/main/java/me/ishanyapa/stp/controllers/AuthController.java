package me.ishanyapa.stp.controllers;

import me.ishanyapa.stp.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/api")
public class AuthController extends BaseController {

    @Autowired
    SessionService sessionService;

    @PostMapping(value = "/login")
    public void login(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (String.valueOf(email).equals("ishanyapa@gmail.com") && String.valueOf(password).equals("123")) {

            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute("username", "ishan");
            response.sendRedirect("/home.html");
            return;
        }

        response.sendError(401);
    }

    @PostMapping(value = "/logout", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void logout(HttpServletRequest request,  HttpServletResponse response) throws IOException {

        sessionService.removeCsrf(request.getSession(false).getId());
        request.getSession(false).invalidate();
        response.sendRedirect("/");
    }

}


