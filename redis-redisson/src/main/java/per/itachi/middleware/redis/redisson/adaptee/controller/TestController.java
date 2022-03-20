package per.itachi.middleware.redis.redisson.adaptee.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import per.itachi.middleware.redis.redisson.adapter.redis.RedisAdapter;

@Slf4j
@RestController
@RequestMapping("/redis")
public class TestController {

    @Autowired
    private RedisAdapter redisAdapter;

    @GetMapping("/lock/{key}")
    @ResponseStatus(HttpStatus.OK)
    public void lock(@PathVariable String key) {
        log.info("{}. ", key);
        redisAdapter.getRedissonLock();
    }

    @PutMapping("/lock")
    @ResponseStatus(HttpStatus.OK)
    public void putLock() {
        redisAdapter.getRedissonLock();
    }

}
