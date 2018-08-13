package me.ishanyapa.stp.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api")
@Controller
public class ContentController {

    @PostMapping(value="/content", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String changeContent(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {


        return "redirect:/home.html";
    }
}
