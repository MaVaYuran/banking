package by.mariayun.web.security;

import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityInitializer() {
        super(WebSecurityConfig.class);
    }
}
