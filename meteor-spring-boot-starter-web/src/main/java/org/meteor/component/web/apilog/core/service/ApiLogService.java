package org.meteor.component.web.apilog.core.service;

import org.meteor.component.web.apilog.core.ApiAccessLog;
import org.meteor.component.web.apilog.core.ApiErrorLog;
import org.springframework.scheduling.annotation.Async;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
public interface ApiLogService {

    /**
     * 创建api访问日志
     * @param apiAccessLog /
     */
    @Async
    void createApiAccessLog(ApiAccessLog apiAccessLog);

    /**
     * 创建api错误日志
     * @param apiErrorLog /
     */
    @Async
    void createApiErrorLog(ApiErrorLog apiErrorLog);
}
