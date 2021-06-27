package cn.yourbatman.foundation.java;

import javax.servlet.http.HttpServletRequest;

/**
 * Web工具方法
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/6/27 11:03
 * @since 0.0.1
 */
public abstract class WebUtils {

    /**
     * 打印{@link HttpServletRequest}的路径信息
     */
    public static void printRequestPath(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
        String requestURI = request.getRequestURI();

        System.out.println("request contextPath：" + contextPath);
        System.out.println("request servletPath：" + servletPath);
        System.out.println("request pathInfo：" + pathInfo);
        System.out.println("request requestURI：" + requestURI);

        System.out.println("request requestURL（用得很少）：" + request.getRequestURL());
        System.out.println("---------------------------");
    }

}
