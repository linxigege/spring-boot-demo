package com.funsonli.springbootdemo062templatefreemarker.controller;

import com.funsonli.springbootdemo062templatefreemarker.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SiteController {

    @GetMapping({"", "/", "index"})
    public String index(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        request.setAttribute("user", user);

        return "site/index";
    }

    @GetMapping("/login")
    public String login() {
        return "site/login";
    }

    @GetMapping("/ajax")
    public String ajax() {
        return "site/ajax";
    }

    @GetMapping("/getCurrentUser")
    @ResponseBody
    public String getCurrentUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return user.getName();
    }

    @PostMapping("/login")
    public String save(@ModelAttribute User modelAttribute, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "binding error";
        }
        request.getSession().setAttribute("user", modelAttribute);
        return "redirect:/";
    }
}
