package xyz.yihuier.logcollector.controller;

import org.elasticsearch.common.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.yihuier.logcollector.domain.WebLog;
import xyz.yihuier.logcollector.kafka.LogProvider;

/**
 * @author linas
 */
@RestController
public class TestController {
    @Autowired
    LogProvider logProvider;

    @PostMapping("/message")
    public void sendMessageToKafkaAndEs(@RequestBody WebLog message) throws Exception {
        logProvider.sendLogMessage(message);
    }
}
