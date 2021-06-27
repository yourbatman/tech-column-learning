package cn.yourbatman.cors.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/6/27 10:20
 * @since 0.0.1
 */
@RestController
public class UrlPathHelperController {

    @Autowired
    private HttpServletRequest request;
    private UrlPathHelper urlPathHelper = new UrlPathHelper();

    @GetMapping("/demo1")
    Object demo1(@RequestParam String name) {
        requestPrint();
        urlPathHelperPrint();

        return "hello " + name;
    }



    private void requestPrint(){
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        StringBuffer requestURL = request.getRequestURL();
        String requestURI = request.getRequestURI();

        System.out.println("request contextPath：" + contextPath);
        System.out.println("request servletPath：" + servletPath);
        System.out.println("request requestURL：" + requestURL);
        System.out.println("request requestURI：" + requestURI);
    }

    private void urlPathHelperPrint(){
        String contextPath = urlPathHelper.getContextPath(request);
        String servletPath = urlPathHelper.getServletPath(request);
        String requestUri = urlPathHelper.getRequestUri(request);


        System.out.println("urlPathHelper contextPath：" + contextPath);
        System.out.println("urlPathHelper servletPath：" + servletPath);
        System.out.println("urlPathHelper requestURL：" + requestUri);
    }



}
