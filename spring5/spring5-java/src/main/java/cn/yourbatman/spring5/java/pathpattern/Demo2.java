package cn.yourbatman.spring5.java.pathpattern;

import org.junit.jupiter.api.Test;
import org.springframework.http.server.PathContainer;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * {@link PathPattern} 是Spring 5推出的用于取代{@link AntPathMatcher}的路径匹配神器。前者性能更强
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/6/18 17:01
 * @since 0.0.1
 * @see PathPattern
 * @see PathPatternParser
 */
public class Demo2 {

    @Test
    public void test1() {
        System.out.println("======={*pathVariable}语法======");
        PathPattern pattern = PathPatternParser.defaultInstance.parse("/api/yourbatman/{*pathVariable}");


        // 提取匹配到的的变量值
        System.out.println("是否匹配：" + pattern.matches(PathContainer.parsePath("/api/yourbatman/a/b/c")));
        PathPattern.PathMatchInfo pathMatchInfo = pattern.matchAndExtract(PathContainer.parsePath("/api/yourbatman/a/b/c"));
        System.out.println("匹配到的值情况：" + pathMatchInfo.getUriVariables());
    }

    @Test
    public void test2() {
        System.out.println("======={*pathVariable}和/**优先级======");
        PathPattern pattern1 = PathPatternParser.defaultInstance.parse("/api/yourbatman/{*pathVariable}");
        PathPattern pattern2 = PathPatternParser.defaultInstance.parse("/api/yourbatman/**");

        SortedSet<PathPattern> sortedSet = new TreeSet<>();
        sortedSet.add(pattern1);
        sortedSet.add(pattern2);

        System.out.println(sortedSet);
    }


    @Test
    public void test3() {
        System.out.println("=======/**放在中间语法======");
        PathPattern pattern = PathPatternParser.defaultInstance.parse("/api/**/yourbatman");

        pattern.matches(PathContainer.parsePath("/api/a/b/c/yourbatman"));
    }

    @Test
    public void test4() {
        System.out.println("======={*pathVariable}放中间代替/**放中间======");
        PathPattern pattern = PathPatternParser.defaultInstance.parse("/api/{*pathVariable}/yourbatman");

        System.out.println(pattern.matches(PathContainer.parsePath("/api/a/b/c/yourbatman")));
    }





}
