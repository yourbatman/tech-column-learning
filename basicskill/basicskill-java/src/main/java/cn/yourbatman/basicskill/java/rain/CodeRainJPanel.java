package cn.yourbatman.basicskill.java.rain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JPanel;

/**
 * 代码雨面板
 * <p>Panel是Java图形用户界面(GUI)工具包swing中的【面板】容器类</p>
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2022/6/3 11:12
 * @since 0.0.1
 */
public class CodeRainJPanel extends JPanel {


    private static final int FONT_SIZE = 33; // 字体大小
    private static final int SPACE = 40; // 字间距
    private static final int SLEEP_TIME = 130; // 休眠时间（ms），可以尽量慢点

    private String[][] charsetArray; // 字符集合（可从文件、外部配置读取），二位数组
    private int[] pos; // 列的起始位置
    private Color[] colors = new Color[10]; //列的渐变颜色

    private List<String> surceLines; // 数据源：按行读取

    public CodeRainJPanel(List<String> surceLines) {
        this.surceLines = surceLines;
    }

    /**
     * 按行随机输出
     */
    private void randomFromSourceLines(String[] charset) {
        int lineCount = this.surceLines.size();

        int length = 0;
        int destPos = 0;
        while (true) {
            int index = ThreadLocalRandom.current().nextInt(lineCount);
            String line = surceLines.get(index); // 从所有行中随机取一行
            String[] lineArray = line.split(""); // 将这一行打散成一个个的字

            boolean breakFlag;
            if (lineArray.length + destPos >= charset.length) {
                length = charset.length - destPos;
                breakFlag = true;
            } else {
                length = lineArray.length;
                breakFlag = false;
            }

            System.arraycopy(lineArray, 0, charset, destPos, length); // 放进charset里
            destPos += length;
            if (breakFlag) {
                break;
            }
        }
    }

    public void init() {
        int width = getWidth(); // 屏幕宽度
        int height = getHeight(); // 屏幕高度

        charsetArray = new String[width / SPACE][height / SPACE];
        for (int i = 0; i < charsetArray.length; i++) {
            randomFromSourceLines(charsetArray[i]);
        }

        //随机化列起始位置
        pos = new int[charsetArray.length];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = ThreadLocalRandom.current().nextInt(1000);
        }

        // 生成渐变色：生成从黑色到绿色的渐变颜色
        for (int i = 0; i < colors.length - 1; i++) {
            colors[i] = new Color(0, 180 / colors.length * (i + 1), 0);
            // colors[i] = new Color(0, 255 / colors.length * (i + 1), 0);
        }

        // 背景颜色
        setBackground(Color.BLACK);
    }

    public void start() {
        init();
        new Thread(() -> {
            while (true) {
                try {
                    repaint(); // 重绘，调用paint()方法
                    Thread.sleep(SLEEP_TIME); // 停一会，继续重回，达到一闪一闪的效果
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        // 按键盘的任意箭退出
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.exit(0);
            }
        });
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                System.exit(0);
//            }
//        });
    }


    @Override
    public void paint(Graphics g) {
        //必须设置，否则setBackground(Color.BLACK); 设置背景色无效
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;// 转换为Graphics2D类型
        g2.setFont(new Font("华文行楷", Font.BOLD, FONT_SIZE));

        for (int i = 0; i < charsetArray.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                int index = (pos[i] + j) % charsetArray[i].length;

//                int R = ThreadLocalRandom.current().nextInt(100);// 随机产生颜色的R值
//                int G = ThreadLocalRandom.current().nextInt(180);// 随机产生颜色的G值
//                int B = ThreadLocalRandom.current().nextInt(100);// 随机产生颜色的B值
//                g2.setColor(new Color(R, G, B));

                g2.setColor(colors[j]); // 纯黑色，黑客帝国的感觉，不够喜庆
                g2.drawString(charsetArray[i][index], i * SPACE, (index + 1) * SPACE);

            }
            pos[i] = (pos[i] + 1) % charsetArray[i].length;
//            if(pos[i]==0){
//                random(charset[i]);
//            }
        }
    }

}
