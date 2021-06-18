package cn.yourbatman.cors.java.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 多Origin响应
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/6/9 10:36
 * @since 0.0.1
 */
@Slf4j
@WebServlet(urlPatterns = "/multiple_origins_cors")
public class MultipleOriginsCorsServlet extends HttpServlet {

    private List<String> ALLOW_ORIGINS = new ArrayList<>();
    
    @Override
    public void init() throws ServletException {
        ALLOW_ORIGINS.add("http://localhost:9090");
        ALLOW_ORIGINS.add("http://foo.baidu.com:9090");
        ALLOW_ORIGINS.add("http://bar.baidu.com:9090");
        ALLOW_ORIGINS.add("http://static.yourbatman.cn:9090");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String method = req.getMethod();
        String originHeader = req.getHeader("Origin");
        log.info("收到请求：{}，方法：{}， Origin头：{}", requestURI, method, originHeader);

        resp.getWriter().write("hello multiple origins cors...");
        setCrosHeader(originHeader, resp);
    }

    /**
     * 写跨域响应头
     */
    // private void setCrosHeader(HttpServletResponse resp) {
    //     resp.setHeader("Access-Control-Allow-Origin", "http://localhost:9090");
    // }
    // private void setCrosHeader(HttpServletResponse resp) {
    //     resp.setHeader("Access-Control-Allow-Origin", "http://foo.baidu.com:9090,http://bar.baidu.com:9090");
    // }
    // private void setCrosHeader(HttpServletResponse resp) {
    //     resp.addHeader("Access-Control-Allow-Origin", "http://foo.baidu.com:9090");
    //     resp.addHeader("Access-Control-Allow-Origin", "http://bar.baidu.com:9090");
    // }
    // private void setCrosHeader(HttpServletResponse resp) {
    //     resp.addHeader("Access-Control-Allow-Origin", "http://*.baidu.com:9090");
    // }
    private void setCrosHeader(String reqOrigin, HttpServletResponse resp) {
        if (reqOrigin == null) {
            return;
        }
        // 匹配算法：equals
        if (ALLOW_ORIGINS.contains(reqOrigin)) {
            resp.addHeader("Access-Control-Allow-Origin", reqOrigin);
        }
    }
}
