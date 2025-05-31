package io.kairos.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        System.out.println("Home Method Called...");
        return "index.jsp";
    }

    @RequestMapping("add")
    public String add() {
        System.out.println("in add");
        return "result.jsp";
    }
}
