package cn.yourbatman.cors.springframework.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 基于{@link CorsConfiguration} 实现
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/6/14 09:50
 * @since 0.0.1
 * @see CorsConfiguration
 */
public class CORSFilterV2 implements Filter {

    private CorsConfiguration corsConfiguration;

    public CORSFilterV2(CorsConfiguration corsConfiguration) {
        this.corsConfiguration = corsConfiguration;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        boolean isValid = process(corsConfiguration, req, resp);
        // Cors跨域不通过，拦截掉
        if (!isValid) {
            return;
        }
        // 如果是预检请求，即使通过了也不让继续往下走了（注：此方法必须放在process()后面，因为响应头得设置好）
        if (CorsUtils.isPreFlightRequest(req)) {
            return;
        }

        chain.doFilter(request, response);
    }

    /**
     * 判断该请求是否匹配Cors跨域规则，并且设置好响应头
     */
    private boolean process(CorsConfiguration corsConfiguration, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 若此请求不是跨域请求，那请回
        if (!CorsUtils.isCorsRequest(request)) {
            return true;
        }
        boolean isRreFlightRequest = CorsUtils.isPreFlightRequest(request);

        // 若此请求你自己已经设置过Access-Control-Allow-Origin，那我也不再处理了
        if (response.getHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN) != null) {
            return true;
        }

        // 若没配置Cors策略，那也什么都不能做
        if (corsConfiguration == null) {
            if (isRreFlightRequest) { //预检请求进来了，但是你又没有配置跨域方案，那肯定拒绝啦
                rejectRequest(response);
                return false;
            }
            return true; // 正常请求进来，没配置跨域方案，那就当此过滤器是空气就好
        }


        // =======配置了跨域方案的校验======
        String requestOrigin = request.getHeader(HttpHeaders.ORIGIN);
        String checkOrigin = corsConfiguration.checkOrigin(requestOrigin);
        if (checkOrigin == null) {
            rejectRequest(response);
            return false;
        }

        // ...检查Methods、检查Headers等等

        // ============开始设置响应头=============
        response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, checkOrigin);
        // if (isRreFlightRequest) {
        //     response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, allowMethods);
        // }
        // if (corsConfiguration.getAllowCredentials() == true) {
        //     response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        // }
        // if (isRreFlightRequest && corsConfiguration.getMaxAge() != null) {
        //     response.addHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE, corsConfiguration.getMaxAge());
        // }
        return true;
    }


    protected void rejectRequest(HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.getWriter().write("Invalid CORS request");
        response.flushBuffer();
    }


}