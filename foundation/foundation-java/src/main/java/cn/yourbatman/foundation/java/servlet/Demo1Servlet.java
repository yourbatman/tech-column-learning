package cn.yourbatman.foundation.java.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static cn.yourbatman.foundation.java.WebUtils.printRequestPath;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/6/27 12:25
 * @since 0.0.1
 */
// @WebServlet(urlPatterns = {"/api/demo1", "/api/demo2"}) // 精确匹配
// @WebServlet(urlPatterns = {"/api/*", "/*"}) // 路径匹配
// @WebServlet(urlPatterns = {"*.jsp", "*.*"}) // 后缀匹配
// @WebServlet(urlPatterns = "/") // 缺省匹配
public class Demo1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printRequestPath(req);
        resp.getWriter().write("hello " + req.getParameter("name"));
    }
}
