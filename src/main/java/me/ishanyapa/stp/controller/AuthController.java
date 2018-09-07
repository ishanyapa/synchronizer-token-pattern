package me.ishanyapa.stp.controller;

import me.ishanyapa.stp.constant.Constants;
import me.ishanyapa.stp.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
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

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void login(@RequestBody MultiValueMap<String, String> form, HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (String.valueOf(form.getFirst(Constants.EMAIL)).equals(Constants.EMAIL_VALUE) && String.valueOf(form.getFirst(Constants.PASSWORD)).equals(Constants.PASSWORD_VALUE)) {
            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute(Constants.USERNAME, Constants.USERNAME_VALUE);
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


