package by.mariayun.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class HomeController {
    @GetMapping("/index")
    public String gotoMain() {
        return "index";
    }

    @GetMapping("/header")
    public String goHeader() {
        return "header";
    }

    @GetMapping("/footer")
    public String goFooter() {
        return "footer";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "main page");
        return "home";
    }
}
