package cn.yourbatman.cors.springframework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/6/18 15:21
 * @since 0.0.1
 */
@RestController
class IndexController {

    @GetMapping("/index")
    Object index() {
        return "Hello Spring";
    }

}
