package net.irq3.blog.configuraiton;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class Bandwidth implements WebMvcConfigurer {
    BandwidthLimiter limiter;

    public Bandwidth(BandwidthLimiter limiter) {
        this.limiter = limiter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(limiter);
    }
}
