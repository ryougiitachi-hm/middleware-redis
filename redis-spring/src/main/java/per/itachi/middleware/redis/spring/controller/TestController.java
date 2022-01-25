package per.itachi.middleware.redis.spring.controller;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/redis")
public class TestController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/key/{key}")
    @ResponseStatus(HttpStatus.OK)
    public void showKeyValue(@PathVariable String key) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        Object value = valueOperations.get(key);
        log.info("key={}, value={}", key, value);
    }


    @PutMapping("/key")
    @ResponseStatus(HttpStatus.OK)
    public void put(@RequestParam String key, @RequestParam String value, @RequestParam(required = false) Long ttl) {
        log.info("key={}, value={}, ttl={}", key, value, ttl);
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        if (ttl == null) {
            valueOperations.set(key, value);
        }
        else {
            valueOperations.set(key, value, Duration.ofMillis(ttl));
        }
    }

}
