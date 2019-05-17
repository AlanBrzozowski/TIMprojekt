package com.timproject.travelapp.security;

import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityApplicationInitializer  extends AbstractSecurityWebApplicationInitializer {
    public SpringSecurityApplicationInitializer() {
        super(SecurityConfig.class);
    }
}
