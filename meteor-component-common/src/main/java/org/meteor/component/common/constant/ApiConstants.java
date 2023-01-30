package org.meteor.component.common.constant;

/**
 * @author 钟宗兵
 * @date 2023/1/14
 * @since 1.0
 **/
public abstract class ApiConstants {
    private ApiConstants() {}
    /**
     * system模块服务名
     */
    public static final String API_SYSTEM_NAME = "system-server";

    public static final String API_SYSTEM_PREFIX = "system";

    public static final String API_SYSTEM_VERSION = "1.0.0";
    /**
     * infra模块服务名
     */
    public static final String API_INFRA_NAME = "infra-server";

    public static final String API_INFRA_PREFIX = "infra";

    public static final String API_INFRA_VERSION = "1.0.0";
}
