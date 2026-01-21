package net.irq3.blog.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class RedisRegisteredClientRepository implements RegisteredClientRepository {

    private final RedisTemplate<String,Object> clientRedisTemplate;

    public RedisRegisteredClientRepository(RegisteredClient client, RedisTemplate<String, Object> clientRedisTemplate) {
        this.clientRedisTemplate = clientRedisTemplate;
        this.save(client);
    }

    @Override public void save(RegisteredClient registeredClient) {
        clientRedisTemplate.opsForValue().set("id:"+registeredClient.getId(), registeredClient, Duration.ofMinutes(20));
        clientRedisTemplate.opsForValue().set("clientId:"+registeredClient.getClientId(), registeredClient.getId(),Duration.ofMinutes(20));

    }

    @Override public RegisteredClient findById(String id) {
        return (RegisteredClient) clientRedisTemplate.opsForValue().get("id:"+id);
    }

    @Override public RegisteredClient findByClientId(String clientId) {
        String id = (String) clientRedisTemplate.opsForValue().get("clientId:"+clientId);
        return (RegisteredClient) clientRedisTemplate.opsForValue().get("id:"+id);

    }
}
