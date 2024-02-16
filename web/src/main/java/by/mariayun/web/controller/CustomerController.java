package by.mariayun.web.controller;

import by.mariayun.service.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.function.Supplier;

//@Controller
@WebServlet
public class CustomerController extends HttpServlet {

    private final CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        customerService.getCustomer(1L);
    }
}
