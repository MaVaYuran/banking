package by.mariayun.web;


import by.mariayun.data.dto.AccountDto;
import by.mariayun.data.dto.CustomerDto;
import by.mariayun.service.AccountService;
import by.mariayun.service.CustomerService;
import by.mariayun.service.security.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class CustomerController {

    private final CustomerService customerService;
    private final AccountService accountService;
    private final AuthenticationService authenticationService;

    public CustomerController(CustomerService customerService, AccountService accountService, AuthenticationService authenticationService) {
        this.customerService = customerService;
        this.accountService = accountService;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("customer", new CustomerDto());
        model.addAttribute("account", new AccountDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute CustomerDto customerDto, HttpServletRequest request, Model model) {
        try {
            CustomerDto customer = authenticationService.register(customerDto, request.getParameter("username"));
            model.addAttribute("customer", customer);
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login() {
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        CustomerDto customerDto = authenticationService.getCustomer();
        if (customerDto != null) {
            model.addAttribute("customer", customerDto);
            List<AccountDto> accounts = customerService.getAllAccounts(customerDto.getId());
            if (!accounts.isEmpty()) {
                model.addAttribute("account", accounts.get(0));
            }
        }
        return "profile";
    }
}
