package com.cg.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    private String getPrincipal() {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }
        else {
            username = principal.toString();
        }

        return username;
    }


    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login");
        return modelAndView;
    }
    @GetMapping("/home")
    public ModelAndView showHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/homepage-dashboard/home");
        String username = getPrincipal();
        modelAndView.addObject("user",username);
        return modelAndView;
    }

    @GetMapping("/user")
    public ModelAndView showUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/list-user");
//        String username= getPrincipal();
//        modelAndView.addObject("user", username);
        return modelAndView;
    }

    @GetMapping("/products")
    public ModelAndView showProductPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/product/list-product");
        return modelAndView;
    }
}
