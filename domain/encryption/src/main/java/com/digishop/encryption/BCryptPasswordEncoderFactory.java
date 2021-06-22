package com.digishop.encryption;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordEncoderFactory {

    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
