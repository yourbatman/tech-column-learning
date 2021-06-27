package cn.yourbatman.spring5.java.antpathmatcher;

import org.junit.jupiter.api.Test;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/6/18 18:01
 * @since 0.0.1
 * @see AntPathMatcher
 */
// @ComponentScan(basePackages = "cn.yourbatman.**.controller")
public class Demo1 {

    private static final PathMatcher MATCHER = new AntPathMatcher();

    @Test
    public void test1() {
        System.out.println("=======?:匹配任意单字符=======");
        String pattern = "/api/your?atman";

        match(1, MATCHER, pattern, "/api/youratman");
        match(2, MATCHER, pattern, "/api/yourBatman");
        match(3, MATCHER, pattern, "/api/yourBatman/address");
        match(4, MATCHER, pattern, "/api/yourBBBatman");
    }

    @Test
    public void test2() {
        System.out.println("=======*:匹配任意数量的字符=======");
        String pattern = "/api/*/yourbatman";

        match(1, MATCHER, pattern, "/api//yourbatman");
        match(2, MATCHER, pattern, "/api/ /yourbatman");
        match(3, MATCHER, pattern, "/api/yourbatman");
        match(4, MATCHER, pattern, "/api/v1v2v3/yourbatman");
    }

    @Test
    public void test3() {
        System.out.println("=======**:匹配任意层级的路径/目录=======");
        String pattern = "/api/yourbatman/**";


        match(1, MATCHER, pattern, "/api/yourbatman");
        match(2, MATCHER, pattern, "/api/yourbatman/");
        match(3, MATCHER, pattern, "/api/yourbatman/address");
        match(4, MATCHER, pattern, "/api/yourbatman/a/b/c");
    }

    @Test
    public void test4() {
        System.out.println("=======**:匹配任意层级的路径/目录=======");
        String pattern = "/api/**/yourbatman";

        match(1, MATCHER, pattern, "/api/yourbatman");
        match(2, MATCHER, pattern, "/api//yourbatman");
        match(3, MATCHER, pattern, "/api/a/b/c/yourbatman");
    }

    @Test
    public void test5() {
        System.out.println("======={pathVariable:可选的正则表达式}=======");
        String pattern = "/api/yourbatman/{age}";

        match(1, MATCHER, pattern, "/api/yourbatman/10");
        match(2, MATCHER, pattern, "/api/yourbatman/Ten");

        // 打印提取到的内容
        extractUriTemplateVariables(MATCHER, pattern, "/api/yourbatman/10");
        extractUriTemplateVariables(MATCHER, pattern, "/api/yourbatman/Ten");
    }

    @Test
    public void test6() {
        System.out.println("======={pathVariable:可选的正则表达式}=======");
        String pattern = "/api/yourbatman/{age:[0-9]*}";

        match(1, MATCHER, pattern, "/api/yourbatman/10");
        match(2, MATCHER, pattern, "/api/yourbatman/Ten");

        // 打印提取到的内容
        extractUriTemplateVariables(MATCHER, pattern, "/api/yourbatman/10");
        extractUriTemplateVariables(MATCHER, pattern, "/api/yourbatman/Ten");
    }

    @Test
    public void test7() {
        System.out.println("=======isPattern方法=======");

        System.out.println(MATCHER.isPattern("/api/yourbatman"));
        System.out.println(MATCHER.isPattern("/api/your?atman"));
        System.out.println(MATCHER.isPattern("/api/*/yourBatman"));
        System.out.println(MATCHER.isPattern("/api/yourBatman/**"));
    }

    @Test
    public void test8() {
        System.out.println("=======matchStart方法=======");
        String pattern = "/api/?";

        System.out.println("match方法结果：" + MATCHER.match(pattern, "/api/y"));
        System.out.println("match方法结果：" + MATCHER.match(pattern, "/api//"));
        System.out.println("match方法结果：" + MATCHER.match(pattern, "/api////"));
        System.out.println("matchStart方法结果：" + MATCHER.matchStart(pattern, "/api//"));
        System.out.println("matchStart方法结果：" + MATCHER.matchStart(pattern, "/api////"));
        System.out.println("matchStart方法结果：" + MATCHER.matchStart(pattern, "/api///a/"));
    }

    @Test
    public void test9() {
        System.out.println("=======extractPathWithinPattern方法=======");
        String pattern = "/api/*.html";

        System.out.println("是否匹配成功：" + MATCHER.match(pattern, "/api/yourbatman/address")
                + "，提取结果：" + MATCHER.extractPathWithinPattern(pattern, "/api/yourbatman/address"));
        System.out.println("是否匹配成功：" + MATCHER.match(pattern, "/api/index.html")
                + "，提取结果：" + MATCHER.extractPathWithinPattern(pattern, "/api/index.html"));
    }

    @Test
    public void test10() {
        System.out.println("=======extractPathWithinPattern方法=======");
        String pattern = "/api/**/yourbatman/*.html/temp";

        System.out.println("是否匹配成功：" + MATCHER.match(pattern, "/api/yourbatman/address")
                + "，提取结果：" + MATCHER.extractPathWithinPattern(pattern, "/api/yourbatman/address"));
        System.out.println("是否匹配成功：" + MATCHER.match(pattern, "/api/yourbatman/index.html/temp")
                + "，提取结果：" + MATCHER.extractPathWithinPattern(pattern, "/api/yourbatman/index.html/temp"));
    }

    @Test
    public void test11() {
        System.out.println("=======getPatternComparator方法=======");

        List<String> patterns = Arrays.asList(
                "/api/**/index.html",
                "/api/yourbatman/*.html",
                "/api/**/*.html",
                "/api/yourbatman/index.html"
        );
        System.out.println("排序前：" + patterns);

        Comparator<String> patternComparator = MATCHER.getPatternComparator("/api/yourbatman/index.html");
        Collections.sort(patterns, patternComparator);
        System.out.println("排序后：" + patterns);
    }

    private static void match(int index, PathMatcher matcher, String pattern, String reqPath) {
        boolean match = matcher.match(pattern, reqPath);
        System.out.println(index + "\tmatch结果：" + pattern + "\t" + (match ? "【成功】" : "【失败】") + "\t" + reqPath);
    }

    private static void extractUriTemplateVariables(PathMatcher matcher, String pattern, String reqPath) {
        Map<String, String> variablesMap = matcher.extractUriTemplateVariables(pattern, reqPath);
        System.out.println("extractUriTemplateVariables结果：" + variablesMap + "\t" + pattern + "\t" + reqPath);
    }


}
