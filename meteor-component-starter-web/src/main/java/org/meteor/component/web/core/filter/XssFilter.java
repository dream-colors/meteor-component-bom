package org.meteor.component.web.core.filter;

import lombok.AllArgsConstructor;
import org.meteor.component.web.config.XssProperties;
import org.springframework.lang.NonNull;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Xss 过滤器
 * <p>
 * 对 Xss 不了解的胖友，可以看看 <a href="http://www.iocoder.cn/Fight/The-new-girl-asked-me-why-AJAX-requests-are-not-secure-I-did-not-answer/">...</a>
 *
 * @author 钟宗兵
 * @date 2023/1/15
 * @since 1.0
 **/
@AllArgsConstructor
public class XssFilter extends OncePerRequestFilter {

    /**
     * 属性
     */
    private final XssProperties properties;
    /**
     * 路径匹配器
     */
    private final PathMatcher pathMatcher;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        filterChain.doFilter(new XssRequestWrapper(request), response);
    }

    @Override
    protected boolean shouldNotFilter(@NonNull HttpServletRequest request) {
        // 如果关闭，则不过滤
        if (!properties.isEnable()) {
            return true;
        }

        // 如果匹配到无需过滤，则不过滤
        String uri = request.getRequestURI();
        return properties.getExcludeUrls().stream().anyMatch(excludeUrl -> pathMatcher.match(excludeUrl, uri));
    }

}
