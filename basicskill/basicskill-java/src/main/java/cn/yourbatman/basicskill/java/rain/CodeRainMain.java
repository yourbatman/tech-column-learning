package cn.yourbatman.basicskill.java.rain;

import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.List;
import javax.swing.JFrame;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

/**
 * 程序入口
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2022/6/3 16:50
 * @since 0.0.1
 */
public class CodeRainMain {

    public static void main(String[] args) throws IOException {
        // 读取端午节祝福语文案
        List<String> lines = IOUtils.readLines(new ClassPathResource("duanwujie.txt").getInputStream(), UTF_8);

        // ========== 读取到文案后，开始展示 =========
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screensize.getWidth() * 0.85); // 笔记本一般是1440
        int height = (int) (screensize.getHeight() * 0.85); // 笔记本一般是900
        System.out.println(format("屏幕大小为：width:%s height:%s", width, height));

        JFrame frame = new JFrame("YourBatman祝：端午安康");
        CodeRainJPanel panel = new CodeRainJPanel(lines); // 自定义的代码雨面板对象

        frame.add(panel); // 将面板添加到JFrame中
        frame.setSize(width, height); // 设置窗口大小
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // 窗体居中显示
        frame.setVisible(true); // 尽快调用paint

        panel.start();
        panel.requestFocus();
    }
}
