package org.meteor.component.web.core.filter;

import cn.hutool.core.text.CharSequenceUtil;
import org.meteor.component.common.enums.SysErrorCodeEnum;
import org.meteor.component.common.pojo.Response;
import org.meteor.component.common.util.servlet.ServletUtils;
import org.meteor.component.web.core.util.WebFrameworkUtils;
import org.springframework.lang.NonNull;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 演示 Filter，禁止用户发起写操作，避免影响测试数据
 *
 * @author 钟宗兵
 * @date 2023/1/15
 * @since 1.0
 **/
public class DemoFilter extends OncePerRequestFilter {

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String method = request.getMethod();
        return !CharSequenceUtil.equalsAnyIgnoreCase(method, "POST", "PUT", "DELETE")
                || WebFrameworkUtils.getLoginUserId(request) == null;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, FilterChain chain) {
        // 直接返回 DEMO_DENY 的结果。即，请求不继续
        ServletUtils.writeJSON(response, Response.buildFailure(SysErrorCodeEnum.DEMO_DENY));
    }

}
