package xyz.yihuier.logcollector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.yihuier.logcollector.api.WebLogMessage;
import xyz.yihuier.logcollector.kafka.LogProvider;

/**
 * @author linas
 */
@RestController
public class TestController {
    @Autowired
    LogProvider logProvider;

    @PostMapping("/message")
    public void sendMessageToKafkaAndEs(@RequestBody WebLogMessage message) throws Exception {
        logProvider.sendLogMessage(message);
    }
}
