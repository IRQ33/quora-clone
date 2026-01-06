package net.irq3.blog.security;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

public class Analitycs {

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent event) {
        // Logika statystyk
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent event) {
        //TODO: Logining it
        if(event.getException() instanceof BadCredentialsException){
            //later send some mail or anythign
        }

    }
}
