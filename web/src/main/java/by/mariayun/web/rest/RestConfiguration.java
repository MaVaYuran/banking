package by.mariayun.web.rest;

import by.mariayun.data.DataConfiguration;
import by.mariayun.data.dao.CustomerDao;
import by.mariayun.data.dto.AccountDto;
import by.mariayun.data.dto.CustomerDto;
import org.springframework.context.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "by.mariayun.web.rest")
@Import(DataConfiguration.class)
public class RestConfiguration {
}