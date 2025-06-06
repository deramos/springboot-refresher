package io.kairos.application.controller;

import io.kairos.application.model.Alien2;
import io.kairos.application.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        System.out.println("Home Method Called...");
        return "index";
    }


    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int num,
                            @RequestParam("num2") int num2,
                            ModelAndView mv) {
        int result = num + num2 + 1;
        System.out.println(result);

        mv.addObject("result", result);
        mv.setViewName("result");

        return mv;
    }

    @RequestMapping("addAlien")
    public ModelAndView addAlien(
            @ModelAttribute Alien2 alien,
            ModelAndView mv) {

        System.out.println(alien);
        mv.setViewName("result");
        return mv;
    }
}
