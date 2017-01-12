package com.cena.odna.core.config.security.exceptions;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * Created by Admin on 12.01.2017.
 */
public class AuthMethodNotSupportedException extends AuthenticationServiceException {
    private static final long serialVersionUID = 3705043083010304496L;

    public AuthMethodNotSupportedException(String msg) {
        super(msg);
    }
}
