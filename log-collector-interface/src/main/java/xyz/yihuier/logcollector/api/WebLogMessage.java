package xyz.yihuier.logcollector.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author linas
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebLogMessage {
    private String app;

    private String host;

    private String result;

//    private List<String> refIds;

//    private List<String> correlationIds;

//    private List<String> clients;

    private String action;

    private String errorCode;

    private String errorMessage;

    private Long elapsed;

    private Map<String, List<String>> context;

    private String requestBody;

    private String responseBody;
}
