package me.ishanyapa.stp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PageController {

    @GetMapping(value="/")
    public String getIndex(HttpServletRequest request, HttpServletResponse response) {

        if(request.getSession(false)== null) {
            return "redirect:/index.html";
        }

        return "redirect:/home.html";
    }

    @GetMapping(value="/control.html")
    public String getControl(HttpServletRequest request, HttpServletResponse response) {

        if(request.getSession(false).getId() != null) {
            return "redirect:/home.html";
        }

        return "redirect:/index.html";
    }

    @GetMapping(value="/home.html")
    public void getHome(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(request.getSession(false) == null) {
            response.sendRedirect("/index.html");
        }
    }

}
