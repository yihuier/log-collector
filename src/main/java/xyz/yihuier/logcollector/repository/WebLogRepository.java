package xyz.yihuier.logcollector.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import xyz.yihuier.logcollector.domain.WebLog;

/**
 * @author yihuier
 */
@Component
public interface WebLogRepository extends ElasticsearchRepository<WebLog, String> {
}
