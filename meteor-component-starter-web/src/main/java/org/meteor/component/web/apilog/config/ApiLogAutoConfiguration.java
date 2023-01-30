package org.meteor.component.web.apilog.config;

import org.meteor.component.web.apilog.core.filter.ApiAccessLogFilter;
import org.meteor.component.web.apilog.core.service.ApiLogService;
import org.meteor.component.common.constant.WebFilterOrder;
import org.meteor.component.web.config.MeteorWebAutoConfiguration;
import org.meteor.component.web.config.WebProperties;
import org.meteor.infra.client.logger.ApiLogApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@AutoConfiguration
@AutoConfigureAfter(MeteorWebAutoConfiguration.class)
public class ApiLogAutoConfiguration {

    @Bean
    public ApiLogService apiLogService(ApiLogApi apiLogApi) {
        return new ApiLogServiceImpl(apiLogApi);
    }

    /**
     * 创建 ApiAccessLogFilter Bean，记录 API 请求日志
     */
    @Bean
    @ConditionalOnProperty(prefix = "meteor.access-log", value = "enable", matchIfMissing = true)
    public FilterRegistrationBean<ApiAccessLogFilter> apiAccessLogFilter(WebProperties webProperties,
                                                                         @Value("${spring.application.name}") String applicationName,
                                                                         ApiLogService apiLogService) {
        ApiAccessLogFilter filter = new ApiAccessLogFilter(webProperties, applicationName, apiLogService);
        return createFilterBean(filter, WebFilterOrder.API_ACCESS_LOG_FILTER);
    }

    private static <T extends Filter> FilterRegistrationBean<T> createFilterBean(T filter, Integer order) {
        FilterRegistrationBean<T> bean = new FilterRegistrationBean<>(filter);
        bean.setOrder(order);
        return bean;
    }

}
