package xyz.yihuier.logcollector.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
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

    @KafkaListener(topics = "log-collect", groupId = "log")
    public void receiveLogMessage(ConsumerRecord<String, WebLog> message) throws IOException {
        sendLogToElasticsearch(message.value());
    }
}
