package xyz.yihuier.logcollector.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * @author linas
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "weblog")
public class WebLog {
    @Id
    private String id;
    private String level;
    private String message;
    private String ipAddress;
    private String requestUrl;
    private String requestMethod;
//    private Map<String, String> requestHeaders;
//    private Map<String, String> requestParams;
    private String requestBody;
//    private Map<String, String> responseHeaders;
    private String responseBody;
    private Long elapsedTime;
    // Getters and setters
}

