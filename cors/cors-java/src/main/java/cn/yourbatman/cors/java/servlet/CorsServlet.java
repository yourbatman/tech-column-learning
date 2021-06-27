package cn.yourbatman.cors.java.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/6/9 10:36
 * @since 0.0.1
 */
@Slf4j
@WebServlet(urlPatterns = "/cors")
public class CorsServlet extends HttpServlet {

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
        // setCrosHeader(resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String method = req.getMethod();
        String originHeader = req.getHeader("Origin");
        log.info("收到请求：{}，方法：{}， Origin头：{}", requestURI, method, originHeader);

        resp.getWriter().write("hello cors...");
        setCrosHeader(resp);
    }

    private void setCrosHeader(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
        resp.setHeader("Access-Control-Expose-Headers", "token,secret");
        resp.setHeader("Access-Control-Allow-Headers", "token,secret"); // 一般来讲，让此头的值是上面那个的【子集】（或相同）
    }
}
