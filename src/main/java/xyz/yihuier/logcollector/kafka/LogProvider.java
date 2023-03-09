package xyz.yihuier.logcollector.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import xyz.yihuier.logcollector.domain.WebLog;

/**
 * @author linas
 */
@Component
public class LogProvider {
    @Autowired
    private KafkaTemplate<String, WebLog> kafkaTemplate;

    public void sendLogMessage(WebLog webLog) {
        kafkaTemplate.send("log-collect", webLog);
    }
}
