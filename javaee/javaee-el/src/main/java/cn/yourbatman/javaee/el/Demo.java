package cn.yourbatman.javaee.el;

import org.junit.jupiter.api.Test;

import javax.el.ELManager;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.StandardELContext;
import javax.el.ValueExpression;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/7/4 10:52
 * @since 0.0.1
 */
public class Demo {

    @Test
    public void test1() {
        ExpressionFactory factory = ELManager.getExpressionFactory();
        StandardELContext elContext = new StandardELContext(factory);

        // 将instance转为对应类型
        ValueExpression valueExpression = factory.createValueExpression("18", Integer.class);
        System.out.println(valueExpression.getValue(elContext));

        // 计算表达式的值
        valueExpression = factory.createValueExpression(elContext, "${1+1}", Integer.class);
        System.out.println(valueExpression.getValue(elContext));

        // 方法调用
        // MethodExpression methodExpression = factory.createMethodExpression(elContext, "${Math.addExact()}", Integer.class, new Class[]{Integer.class, Integer.class});
        // System.out.println(methodExpression.invoke(elContext, new Object[]{1, 2}));
    }
}
