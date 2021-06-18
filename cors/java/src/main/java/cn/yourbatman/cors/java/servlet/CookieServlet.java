package cn.yourbatman.cors.java.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/6/9 10:36
 * @since 0.0.1
 */
@Slf4j
@WebServlet(urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String method = req.getMethod();
        String originHeader = req.getHeader("Origin");
        log.info("收到请求：{}，方法：{}， Origin头：{}", requestURI, method, originHeader);

        // 读取Cookie
        List<Cookie> myCookies = new ArrayList<>();
        if (req.getCookies() != null) {
            myCookies = Arrays.stream(req.getCookies()).filter(c -> c.getName().equals("name") || c.getName().equals("age")).collect(toList());
        }

        if (myCookies.isEmpty()) { // 种植Cookie
            Cookie cookie = new Cookie("name", "YourBatman");
            // cookie.setDomain("baidu.com");
            cookie.setMaxAge(3600);
            resp.addCookie(cookie);
            cookie = new Cookie("age", "18");
            cookie.setMaxAge(3600);
            resp.addCookie(cookie);
        } else {
            myCookies.stream().forEach(c -> {
                log.info("name:{} value:{} domain:{} path:{} maxAge:{} secure:{}", c.getName(), c.getValue(), c.getDomain(), c.getPath(), c.getMaxAge(), c.getVersion(), c.getSecure());
            });
        }

        resp.getWriter().write("hello cookie...");
    }
}
