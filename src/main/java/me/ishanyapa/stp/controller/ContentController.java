package me.ishanyapa.stp.controller;

import me.ishanyapa.stp.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/api")
@Controller
public class ContentController extends BaseController {

    @Autowired
    SessionService sessionService;

    @PostMapping(value="/content")
    public void changeContent(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("_csrf") String _csrf,
                              HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws IOException {

        if (sessionService.getCsrf(request.getSession(false).getId()).equals(_csrf)) {
            response.sendRedirect("/home.html");
            return;
        }

        response.sendError(400);
    }
}
