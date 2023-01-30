package org.meteor.component.web.apilog.config;

import org.meteor.infra.client.logger.ApiLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * API 日志使用到 Feign 的配置项 主要是引入相关的 API 服务
 *
 * @author 钟宗兵
 */
@AutoConfiguration
@EnableFeignClients(basePackageClasses = {ApiLogApi.class})
public class ApiLogRpcAutoConfiguration {
}
