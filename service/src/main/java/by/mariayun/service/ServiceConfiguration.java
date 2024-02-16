package by.mariayun.service;

import by.mariayun.data.DataConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "by.mariayun.service")
@Import(DataConfiguration.class)
public class ServiceConfiguration {
}
