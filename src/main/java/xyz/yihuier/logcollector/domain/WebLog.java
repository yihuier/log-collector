package xyz.yihuier.logcollector.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Map;

/**
 * @author linas
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebLog {
    private String id;
    private String level;
    private String message;
    private ZonedDateTime timestamp;
    private String ipAddress;
    private String requestUrl;
    private String requestMethod;
    private Map<String, String> requestHeaders;
    private Map<String, String> requestParams;
    private String requestBody;
    private Map<String, String> responseHeaders;
    private String responseBody;
    private Long elapsedTime;
    // Getters and setters
}

