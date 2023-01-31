package org.meteor.component.web.apilog.core;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Data
public class ApiAccessLog extends ApiLog {
    /**
     * 开始请求时间
     */
    @NotNull(message = "开始请求时间不能为空")
    private LocalDateTime beginTime;
    /**
     * 结束请求时间
     */
    @NotNull(message = "结束请求时间不能为空")
    private LocalDateTime endTime;
    /**
     * 执行时长，单位：毫秒
     */
    @NotNull(message = "执行时长不能为空")
    private Integer duration;
    /**
     * 结果码
     */
    @NotNull(message = "错误码不能为空")
    private Integer resultCode;
    /**
     * 结果提示
     */
    private String resultMsg;
}
