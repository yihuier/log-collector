package xyz.yihuier.logcollector.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import xyz.yihuier.logcollector.domain.WebLog;

import java.io.IOException;

/**
 * @author linas
 */
@Component
public class LogConsumer {
    @Autowired
    private RestClientBuilder restClientBuilder;

    public void sendLogToElasticsearch(WebLog logMessage) throws IOException {
        RestClient restClient = restClientBuilder.build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(logMessage);
        StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
        Request request = new Request("POST", "log/_doc");
        request.setEntity(entity);
        Response response = restClient.performRequest(request);
        restClient.close();
    }

    @KafkaListener(topics = "log-collect", groupId = "log")
    public void receiveLogMessage(WebLog message) throws IOException {
        sendLogToElasticsearch(message);
    }
}
