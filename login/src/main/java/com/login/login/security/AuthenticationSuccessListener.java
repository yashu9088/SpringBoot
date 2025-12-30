package com.login.login.security;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

public class AuthenticationSuccessListener  implements ApplicationListener<AuthenticationSuccessEvent> {
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {

        String username = event.getAuthentication().getName();

        System.out.println("✅ LOGIN SUCCESS: " + username);
    }

}