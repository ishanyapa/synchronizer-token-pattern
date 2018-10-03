package me.ishanyapa.stp.controller;

import me.ishanyapa.stp.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping(value="/content",  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void changeContent(@RequestBody MultiValueMap<String, String> form,
                              HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws IOException {

        String _csrf = form.getFirst("_csrf");
        if (sessionService.getCsrf(request.getSession(false).getId()).equals(_csrf)) {
            response.setStatus(201);
            response.sendRedirect("/home.html?status=success");
            return;
        }
        response.setStatus(400);
        response.sendRedirect("/home.html?status=failed");
    }
}
