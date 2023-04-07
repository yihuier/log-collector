package xyz.yihuier.logcollector.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import xyz.yihuier.logcollector.api.WebLogMessage;
import xyz.yihuier.logcollector.api.topic.LogCollectorKafkaTopic;

/**
 * @author linas
 */
@Component
public class LogProvider {
    @Autowired
    private KafkaTemplate<String, WebLogMessage> kafkaTemplate;

    public void sendLogMessage(WebLogMessage webLog) {
        kafkaTemplate.send(LogCollectorKafkaTopic.LOG_COLLECT, webLog);
    }
}
