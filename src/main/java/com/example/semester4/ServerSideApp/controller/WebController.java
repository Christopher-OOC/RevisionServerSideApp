package com.example.semester4.ServerSideApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/splacky-recipes")
public class WebController {

    @GetMapping(value = "/")
    public String showHomePage() {

        return "home";
    }
}
