package com.login.login.security;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;

public class AuthenticationFailureListener implements ApplicationListener<AbstractAuthenticationFailureEvent> {
    @Override
    public void onApplicationEvent(AbstractAuthenticationFailureEvent event) {

        String username = event.getAuthentication().getName();

        System.out.println("❌ LOGIN FAILED: " + username);
    }
}