package per.itachi.middleware.redis.spring.listener;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedisEventMessageListener implements MessageListener {

    @PostConstruct
    public void init() {
        log.info("RedisEventMessageListener");
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("Key space happended, channel={}, body={}. ",
                new String(message.getChannel()), new String(message.getBody()) );
    }
}