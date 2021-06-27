package cn.yourbatman.spring5.java.pathpattern;

import org.junit.jupiter.api.Test;
import org.springframework.http.server.PathContainer;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

import java.time.Duration;
import java.time.Instant;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/6/20 17:25
 * @since 0.0.1
 */
public class CompareDemo {


    private static final String pattern = "/api/your?atman/{age}/**";

    @Test
    public void test1() {
        Instant start = Instant.now();
        for (int i = 0; i < 10000000; i++) {
            String reqPath = "/api/yourBatman/" + i + "/" + i;
            // antPathMatcher(reqPath);
            pathPattern(reqPath);
        }
        System.out.println("耗时(ms)：" + Duration.between(start, Instant.now()).toMillis());
    }


    private static final PathMatcher MATCHER = new AntPathMatcher();

    public static void antPathMatcher(String reqPath) {
        MATCHER.match(pattern, reqPath);
    }

    private static final PathPattern PATTERN = PathPatternParser.defaultInstance.parse(pattern);

    public static void pathPattern(String reqPath) {
        PATTERN.matches(PathContainer.parsePath(reqPath));
    }


}
