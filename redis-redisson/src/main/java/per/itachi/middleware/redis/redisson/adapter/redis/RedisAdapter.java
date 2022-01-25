package per.itachi.middleware.redis.redisson.adapter.redis;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedisAdapter {

    @Autowired
    private RedissonClient redissonClient;

    @PostConstruct
    public void init() {
        log.info("Started locking. ");
        RLock rLock = redissonClient.getLock("hcp:lock:game:1");
        rLock.lock();redissonClient.reactive();
    }
}