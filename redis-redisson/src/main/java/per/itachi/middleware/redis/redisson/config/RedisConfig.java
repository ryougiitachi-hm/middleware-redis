package per.itachi.middleware.redis.redisson.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
//                .setsc
                .setAddress("redis://127.0.0.1:6301"); // simple 127.0.0.1:6301 will throw exception.
        RedissonClient client  = Redisson.create(config);
        return client;
    }
}
