package cn.yourbatman.foundation.java.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/6/27 17:38
 * @since 0.0.1
 */
// @WebFilter(urlPatterns = {"/"}) // Filter使用/无效果，拦截所有只能使用/*
// @WebFilter(urlPatterns = {"/*"})
public class FakeFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("FakeFilter收到请求：" + req.getRequestURI());
        super.doFilter(req, res, chain);
    }
}
