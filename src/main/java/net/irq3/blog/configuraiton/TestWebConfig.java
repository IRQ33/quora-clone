package net.irq3.blog.configuraiton;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile(value = "dev")
@Configuration
public class TestWebConfig {

//    @Bean
//    SecurityFilterChain securityFilterChain (HttpSecurity security) throws Exception{
//        return security.authorizeHttpRequests(req -> req.anyRequest()
//                .permitAll()).csrf(AbstractHttpConfigurer::disable).build();
//    }
}
