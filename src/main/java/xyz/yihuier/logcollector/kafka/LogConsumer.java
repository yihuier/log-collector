package xyz.yihuier.logcollector.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import xyz.yihuier.logcollector.constant.LogCollectorKafkaGroup;
import xyz.yihuier.logcollector.constant.LogCollectorKafkaTopic;
import xyz.yihuier.logcollector.domain.WebLog;
import xyz.yihuier.logcollector.repository.WebLogRepository;

import java.io.IOException;

/**
 * @author linas
 */
@Component
public class LogConsumer {
    @Autowired
    WebLogRepository webLogRepository;

    public void sendLogToElasticsearch(WebLog logMessage) throws IOException {
        webLogRepository.save(logMessage);
    }

    @KafkaListener(topics = LogCollectorKafkaTopic.LOG_COLLECT, groupId = LogCollectorKafkaGroup.LOG_COLLECT_GROUP)
    public void receiveLogMessage(ConsumerRecord<String, WebLog> message) throws IOException {
        sendLogToElasticsearch(message.value());
    }
}
