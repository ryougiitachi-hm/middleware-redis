package per.itachi.middleware.redis.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisClientApplication.class, args);
    }
}
