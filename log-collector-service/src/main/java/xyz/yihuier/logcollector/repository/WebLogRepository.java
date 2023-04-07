package xyz.yihuier.logcollector.repository;

import xyz.yihuier.logcollector.domain.WebLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author yihuier
 */
@Component
public interface WebLogRepository extends ElasticsearchRepository<WebLog, String> {
}
