package xyz.yihuier.logcollector.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import xyz.yihuier.logcollector.api.WebLogMessage;
import xyz.yihuier.logcollector.api.topic.LogCollectorKafkaTopic;
import xyz.yihuier.logcollector.domain.WebLog;
import xyz.yihuier.logcollector.repository.WebLogRepository;

import java.io.IOException;
import java.time.Instant;
import java.util.UUID;

/**
 * @author linas
 */
@Component
public class LogConsumer {
    @Autowired
    WebLogRepository webLogRepository;

    public void sendLogToElasticsearch(WebLogMessage logMessage) throws IOException {
        var message = new WebLog();
        message.setId(UUID.randomUUID().toString());
        message.setTimestamp(Instant.now());
        message.setApp(logMessage.getApp());
        message.setHost(logMessage.getHost());
        message.setResult(logMessage.getResult());
        message.setAction(logMessage.getAction());
        message.setErrorCode(logMessage.getErrorCode());
        message.setErrorMessage(logMessage.getErrorMessage());
        message.setElapsed(logMessage.getElapsed());
        message.setContext(logMessage.getContext());
        message.setRequestBody(logMessage.getRequestBody());
        message.setResponseBody(logMessage.getResponseBody());
        webLogRepository.save(message);
    }

    @KafkaListener(topics = LogCollectorKafkaTopic.LOG_COLLECT)
    public void receiveLogMessage(ConsumerRecord<String, WebLogMessage> message) throws IOException {
        sendLogToElasticsearch(message.value());
    }
}
