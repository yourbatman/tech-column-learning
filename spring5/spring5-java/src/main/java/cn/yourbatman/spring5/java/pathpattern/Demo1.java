package cn.yourbatman.spring5.java.pathpattern;

import org.junit.jupiter.api.Test;
import org.springframework.http.server.PathContainer;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/6/20 09:47
 * @since 0.0.1
 */
public class Demo1 {

    /**
     * 将pattern字符串的每一段都解析为element，用链状形式连接起来
     */
    @Test
    public void test1() {
        PathPatternParser parser = new PathPatternParser();
        PathPattern pathPattern = parser.parse("/api/v1/**");
        System.out.println(pathPattern);
    }

    @Test
    public void test2() {
        PathContainer pathContainer = PathContainer.parsePath("/api/v1/address", PathContainer.Options.HTTP_PATH);
        System.out.println(pathContainer);
    }
}
