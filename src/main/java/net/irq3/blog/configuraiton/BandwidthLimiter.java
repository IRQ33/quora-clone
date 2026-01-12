package net.irq3.blog.configuraiton;

import io.github.bucket4j.Bucket;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.irq3.blog.controllers.UserController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.Duration;

@Component
public class BandwidthLimiter implements HandlerInterceptor {
    //TODO: On production 5 tokens/hour
    private final Bucket bucket = Bucket.builder()
            .addLimit(limit-> limit.capacity(5)
                    .refillGreedy(5, Duration.ofSeconds(1))).build();


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod)
        {
            if(((HandlerMethod) handler).getBeanType().equals(UserController.class))
            {
                if(!bucket.tryConsume(1))
                {
                    response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
                    return false;
                }
            }
        }

        return true;
    }
}
