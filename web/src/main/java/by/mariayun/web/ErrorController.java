package by.mariayun.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ErrorController {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @GetMapping("/error")
    public String exception(final Throwable throwable, final Model model) {
        String errorMessage = (throwable != null ? throwable.getMessage() : "Something went wrong");
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }
}


