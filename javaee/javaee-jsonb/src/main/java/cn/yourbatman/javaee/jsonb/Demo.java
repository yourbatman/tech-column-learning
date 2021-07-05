package cn.yourbatman.javaee.jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/7/4 18:51
 * @since 0.0.1
 */
public class Demo {

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("YourBatman");
        p.setAge(18);

        Jsonb jsonb = JsonbBuilder.create();
        String json = jsonb.toJson(p);
        System.out.println("序列化结果：" + json);

        // 反序列化
        System.out.println(jsonb.fromJson(json, Person.class));
    }

}
