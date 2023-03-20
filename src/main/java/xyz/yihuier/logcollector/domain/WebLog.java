package xyz.yihuier.logcollector.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * @author linas
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "web_log")
public class WebLog {
    @Id
    private String id;

    @Field(name = "@timestamp", type = FieldType.Date)
    private Instant timestamp;
    
    @Field(name = "app", type = FieldType.Keyword)
    private String app;
    
    @Field(name = "host", type = FieldType.Keyword)
    private String host;
    
    @Field(name = "result", type = FieldType.Keyword)
    private String result;
    
//    @Field(name = "ref_id")
//    private List<String> refIds;
    
//    @Field(name = "correlation_id")
//    private List<String> correlationIds;
    
//    @Field(name = "client")
//    private List<String> clients;
    
    @Field(name = "action", type = FieldType.Keyword)
    private String action;
    
    @Field(name = "error_code", type = FieldType.Keyword)
    private String errorCode;
    
    @Field(name = "error_message", type = FieldType.Text)
    private String errorMessage;
    
    @Field(name = "elapsed", type = FieldType.Long)
    private Long elapsed;
    
    @Field(name = "context", type = FieldType.Nested, includeInParent = true)
    private Map<String, List<String>> context;

    @Field(name = "request_body", type = FieldType.Text)
    private String requestBody;

    @Field(name = "response_body", type = FieldType.Text)
    private String responseBody;
}

