###  :man_technologist:  [方向盘(YourBatman、方哥)](https://yourbatman.cn) | 做爱做之事❣交配交之人
我是[**方向盘(YourBatman、方哥)**](https://mp.weixin.qq.com/s/PGIFtpI7aZaxY7es0F6C6Q)：一个前25年还不会写Hallo World、早已毕业的[**大龄程序员**](https://yourbatman.cn/about)。网瘾失足、清考、延期毕业、房产中介、保险销售、送外卖...是我不可抹灭的黑标签

---

<br/>
<div align="center">
    <a href="https://yourbatman.cn" style="text-decoration:none"><img src="https://cdn.jsdelivr.net/gh/yourbatman/cdn/blog/books/image/book_logo.png" width="128px"></a>
</div>
<br/>

<div align="center">
<a href="https://github.com/yourbatman/tech-column-learning"><img src="https://badgen.net/github/stars/spring-projects/spring-framework?icon=github&color=4ab8a1"></a>
<a href="https://github.com/yourbatman/tech-column-learning"><img src="https://badgen.net/github/forks/spring-projects/spring-framework?icon=github&color=4ab8a1"></a>
<a href="https://yourbatman.cn/columns" target="_blank"><img src="https://cdn.jsdelivr.net/gh/yourbatman/cdn/blog/image/yourbatman/svg/onlinebook.svg"></a>
<a href="https://bugstack.cn/assets/images/qrcode.png?x-oss-process=style/may"><img src="https://cdn.jsdelivr.net/gh/yourbatman/cdn/blog/image/yourbatman/svg/wechat-public-wenzi.svg"></a>
</div>
<br/>

本仓库是你需要的专栏【**大本营**】，汇聚了方向盘(YourBatman、方哥)原创的几十个小而美的技术专栏，万丈高楼平地起，打实基础方可走得更快、更远。

## 专栏目录
| 序号 | 专栏名称                                     |                 专栏地址                    |
| :--: | --------------------------------------------- | --------------------------------------------- |
| 01 | 【方向盘】-程序人生 | 待归档... |
| 02 | 【方向盘】-日期时间 | 待归档... |
| 03 | 【方向盘】-资讯/新特性 | 待归档... |
| 04 | 【方向盘】-Spring static | 待归档... |
| 05 | 【方向盘】-Bean Validation | 待归档... |
| 06 | 【方向盘】-Servlet | 待归档... |
| 07 | 【方向盘】-Spring技术栈 | 待归档... |
| 08 | 【方向盘】-JDK | 待归档... |
| 09 | 【方向盘】-Cors跨域 | 待归档... |
| 10 | 【方向盘】-Spring配置类 | 待归档... |
| 11 | 【方向盘】-Spring类型转换 | 待归档... |
| 12 | 【方向盘】-Jackson | 待归档... |
| 13 | 【方向盘】-IntelliJ IDEA | 待归档... |
| 14 | 【方向盘】-Java EE | [专栏地址](https://github.com/yourbatman/FXP-java-ee) |
| 15 | 待归档... | 待归档... | 待归档... |

> Tips：关注公众号【Java方向盘】，后台回复"专栏列表"，可【提前阅读】上面专栏内容

## 阅读说明书
本着追本溯源，拒绝浅尝辄止的学习目的。自上而下的应用，自底向上的学习，做到学有所成，**既知所用又懂原理方可通透**。

（几乎）所有专栏会按照三步曲进行展开：
1. 基础：万丈高楼平地起。深入了解其设计理念、架构思想、组件功能、API设计
2. 进阶：协同进阶以拔高。高级功能、和其它组件/框架协同使用
3. 应用：智能整合供应用。如何智能化、简单化供给开发者使用，是一个产品的外观

三步曲体现在工程目录上如下结构所示：
```
|-- project
    |-- cors // 专栏名
    |   |-- cors-java
    |   |-- cors-spring-framework
    |   |-- cors-spring-boot
    |-- xxx // 专栏名
    |   |-- xxx-java
    |   |-- xxx-spring-framework
    |   |-- xxx-spring-boot
```
1. xxx-java工程：最纯粹工程。去除一切非相关依赖，直接接触**底层API**。深入理解其设计思想。
   - 一般来讲该工程仅依赖JDK以及该专题设计的【底层基础Jar包】
   - 启动/运行方式：main方法（servlet web工程除外，需要war包方式部署到外置Tomcat启动） 
2. xxx-spring-framework工程：通过扩展点和Spring框架整合。只有进阶了解了Spring Framework的协同使用，才会有对原理更深一层的理解
   - 一般来讲该工程会依赖【Spring容器】，在上工程基础上引入Spring Framework相关依赖
   - 启动/运行方式：main方法（spring web工程除外，需要war包方式部署到外置Tomcat启动） 
3. xxx-spirng-boot工程；一切的最终目的都是使用。而开发者必定面向更加智能化的Spring Boot开发应用
    - 一般来讲这是最后一步。Spring Boot是高度封装、智能化的基础框架，一切专题/组件最后都需和它整合方可使用
    - 启动/运行方式：main方法

---

### 联系我
> - 🎓2013.07 清考、毕业答辩3次未通过、延期毕业
> - 🏷2013.08-2014.07 宁夏中介公司卖二手房1年，毕业后第1份工作
> - ️️🏷2014.07-2015.05 荆州/武汉，泰康人寿卖保险3月、饿了么送外卖2月，还有炸鸡排、直销等第2345份工作
> - 🏷2015.08 开始从事Java开发，闯过外包，呆过大厂！多年架构经验，任基础架构/中间件团队负责人
> - 🏷2021.08 [因“双减政策”失业！历经9面，终获美团外卖L8的offer](https://mp.weixin.qq.com/s/tMiDQXPt2Gw3hRikAGibAg)
> -
> - 🙅🏻‍♀️Java架构师、Spring开源贡献者、CSDN博客之星年度Top 10、领域建模专家、写作大赛1/2届评委
> - 📚将出版书籍《Spring奇淫巧技》，致力于国内zui好、zui具深度、zui实用的专栏，为市场贡献微薄之力
> -
> - 现在写纯粹技术专栏（公号后台回复**专栏列表**），不哗众取宠。如果你也有共鸣，可加我好友(fsx1056342982)一起进步

- Contact me：[方向盘(YourBatman、方哥)](https://yourbatman.cn)
- 公众号：[Java方向盘](https://cdn.jsdelivr.net/gh/yourbatman/cdn/blog/image/yourbatman/wechat-public-8cm.jpg)
- 我的站点：[https://yourbatman.cn](https://yourbatman.cn)
- 我的网盘：[https://wangpan.yourbatman.cn](https://wangpan.yourbatman.cn)
   - 注册送1G超小容量，助你做减法（为什么要做减法？读这里：[做加法容易做减法难，程序员的我深有同感](https://yourbatman.cn/x2y/89616c6e.html)）

![Java方向盘-搜一搜](https://cdn.jsdelivr.net/gh/yourbatman/cdn/blog/image/yourbatman/wechat-public-soso-qrcode.png)

### 实用工具
- 【女娲Knife-Initializr工程】访问地址：[http://152.136.106.14:8761](http://152.136.106.14:8761)
- 【程序员专用网盘】公益上线啦，注册送1G超小容量，帮你实践做**减法**：[https://wangpan.yourbatman.cn](https://mp.weixin.qq.com/s/e_ffqJd7edyCM8celr-Uww)
- 【Java开发软件包(Mac)】：[https://wangpan.yourbatman.cn/s/rEH0](https://wangpan.yourbatman.cn/s/rEH0) 提取码：javakit

### 期待与你相遇
喜欢交朋友，喜欢讨论技术，更喜欢向你学习。<img src="https://media.giphy.com/media/LnQjpWaON8nhr21vNW/giphy.gif" width="60">期待在程序的世界里我们能相遇！

---
*由于作者水平有限，可能存在描述不准确或错别字内容，👏🏻欢迎随时反馈给我。我是方向盘(YourBatman、方哥)，一个纯粹技术工！*