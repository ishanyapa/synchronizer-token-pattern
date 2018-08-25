package me.ishanyapa.stp.controllers;

import me.ishanyapa.stp.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/api")
@Controller
public class ContentController extends BaseController {

    @Autowired
    SessionService sessionService;

    @PostMapping(value="/content")
    public String changeContent(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("_csrf") String _csrf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {

        if (sessionService.getCsrf(request.getSession(false).getId()).equals(_csrf)) {
            return "redirect:/home.html";
        }

        return "redirect:/error.html";
    }
}
