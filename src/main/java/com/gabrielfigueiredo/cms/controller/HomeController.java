package com.gabrielfigueiredo.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String redirectToSwagger() {
        return "redirect:/swagger-ui.html";
    }
}
