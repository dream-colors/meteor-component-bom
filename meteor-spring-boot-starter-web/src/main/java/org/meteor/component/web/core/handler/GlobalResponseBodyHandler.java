package org.meteor.component.web.core.handler;

import org.meteor.component.web.apilog.core.filter.ApiAccessLogFilter;
import org.meteor.component.common.pojo.response.Response;
import org.meteor.component.common.pojo.response.SingleResponse;
import org.meteor.component.web.core.util.WebFrameworkUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 全局响应结果（ResponseBody）处理器
 * <p>
 * 不同于在网上看到的很多文章，会选择自动将 Controller 返回结果包上 {@link Response}，
 * 在 onemall 中，是 Controller 在返回时，主动自己包上 {@link Response}。
 * 原因是，GlobalResponseBodyHandler 本质上是 AOP，它不应该改变 Controller 返回的数据结构
 * <p>
 * 目前，GlobalResponseBodyHandler 的主要作用是，记录 Controller 的返回结果，
 * 方便 {@link ApiAccessLogFilter} 记录访问日志
 *
 * @author 钟宗兵
 * @date 2023/1/15
 * @since 1.0
 **/
@ControllerAdvice
public class GlobalResponseBodyHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class converterType) {
        Method method = methodParameter.getMethod();
        if (method == null) {
            return false;
        }
        // 只拦截返回结果为 Response 类型
        return method.getReturnType() == Response.class;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        // 记录 Controller 结果
        HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
        if (body == null) {
            WebFrameworkUtils.setCommonResult(servletRequest, Response.success());
            return Response.success();
        }
        if (body instanceof Response) {
            WebFrameworkUtils.setCommonResult(servletRequest, (Response) body);
            return body;
        }
        WebFrameworkUtils.setCommonResult(servletRequest, SingleResponse.of(body));
        return SingleResponse.of(body);
    }

}
