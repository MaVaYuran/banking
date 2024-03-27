package by.mariayun.rest;

import by.mariayun.data.DataConfiguration;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "by.mariayun.rest")
@Import(DataConfiguration.class)
public class RestConfiguration {
}