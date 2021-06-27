package cn.yourbatman.cors.java.spring;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.Collections;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/6/26 08:00
 * @since 0.0.1
 * @see CorsConfiguration
 */
public class CorsConfigurationDemo {

    @Test
    public void test() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.setAllowCredentials(true);

        // 验证：请求Request的此Origin是否合法
        String checkedOrigin = corsConfiguration.checkOrigin("https://yourbatman.cn");
        System.out.println("Access-Control-Allow-Origin的值为：" + checkedOrigin);
    }


    /**
     * allowedOriginPatterns使用示例
     */
    @Test
    public void test1() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 正常的模式匹配(字面量匹配就不演示了)
        corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("https://*.yourbatman.cn:[8080,8081]"));
        System.out.println("Access-Control-Allow-Origin的值为：" + corsConfiguration.checkOrigin("https://blog.yourbatman.cn:8081"));

        // 使用*进行通配，同时allowCredentials设置为true
        corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));
        corsConfiguration.setAllowCredentials(true);
        System.out.println("Access-Control-Allow-Origin的值为：" + corsConfiguration.checkOrigin("https://blog.yourbatman.cn:8081"));
    }

    @Test
    public void test2() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.setAllowedOrigins(Collections.singletonList("*"));
        System.out.println("Access-Control-Allow-Origin的值为：" + corsConfiguration.checkOrigin("https://blog.yourbatman.cn:8081"));
    }

    @Test
    public void test3() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 默认case：放行GET和HEAD
        System.out.println("allowedMethods的值为：" + corsConfiguration.getAllowedMethods());
        System.out.println(corsConfiguration.checkHttpMethod(HttpMethod.GET));
        System.out.println(corsConfiguration.checkHttpMethod(HttpMethod.POST));
    }

    @Test
    public void test4() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 手动明确指定只支持get（即使调用的是add方法），那就只支持GET喽
        corsConfiguration.setAllowedMethods(Collections.singletonList("GET"));
        System.out.println("allowedMethods的值为：" + corsConfiguration.getAllowedMethods());
        System.out.println(corsConfiguration.checkHttpMethod(HttpMethod.GET));
        System.out.println(corsConfiguration.checkHttpMethod(HttpMethod.HEAD));


        corsConfiguration.addAllowedMethod("HEAD");
        System.out.println("allowedMethods的值为：" + corsConfiguration.getAllowedMethods());
        System.out.println(corsConfiguration.checkHttpMethod(HttpMethod.GET));
        System.out.println(corsConfiguration.checkHttpMethod(HttpMethod.HEAD));
        System.out.println(corsConfiguration.checkHttpMethod(HttpMethod.POST));

        // 当添加一个*号时
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        System.out.println("allowedMethods的值为：" + corsConfiguration.getAllowedMethods());
        System.out.println(corsConfiguration.checkHttpMethod(HttpMethod.GET));
        System.out.println(corsConfiguration.checkHttpMethod(HttpMethod.HEAD));
        System.out.println(corsConfiguration.checkHttpMethod(HttpMethod.POST));
        System.out.println(corsConfiguration.checkHttpMethod(HttpMethod.PUT));
        System.out.println(corsConfiguration.checkHttpMethod(HttpMethod.DELETE));
    }

    @Test
    public void test5() {
        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();

        corsConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "YourBatman"));
        System.out.println(corsConfiguration.checkHeaders(Arrays.asList("Authorization", "YourBatman")));
        System.out.println(corsConfiguration.checkHeaders(Arrays.asList("yourbatman", "Name")));

        // 添加一个通配符*
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        System.out.println(corsConfiguration.checkHeaders(Arrays.asList("Name", "Age")));
    }
}
