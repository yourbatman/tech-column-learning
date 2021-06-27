## 技术专栏 | 源代码合集
> 我是[YourBatman](https://yourbatman.cn/about)：一个早在2013年就已毕业的[大龄程序员](https://mp.weixin.qq.com/s/PGIFtpI7aZaxY7es0F6C6Q)。网瘾失足、清考、延期毕业、房产中介、送外卖、销售...是我不可抹灭的标签。
> - **2013.08-2014.07**宁夏银川中介公司卖二手房1年，毕业后第1份工作
> - **2014.07-2015.05**荆州/武汉/北京，从事炸鸡排、卖保险、直销、送外卖工作，这是第2,3,4,5份工作
> - **2015.08**开始从事Java开发，做过兼职，闯过外包，呆过大厂！现为我司**基础架构**团队负责人。Java架构师、Spring开源贡献者，博客专家，领域建模专家。热衷写代码，有代码洁癖；重视基础和基建，相信效率为王
> - 现在写纯粹技术专栏（公号后台回复**专栏列表**获取全部），不哗众取宠。如果你也有共鸣，可加我好友一起进步哈（备注：java）

本代码库是YourBatman原创技术专栏的源代码合集，对照专栏文章阅读效果最佳。电梯直达：[技术专栏](https://yourbatman.cn/columns)
> 随着专栏的新增（or搬迁），该代码库会定期更新。建议start/Fork/clone此项目，保持最新状态

<br/>
<div align="center">
    <a href="https://yourbatman.cn" style="text-decoration:none"><img src="https://cdn.jsdelivr.net/gh/yourbatman/cdn/blog/books/image/book_logo.png" width="128px"></a>
</div>
<br/>

## 目录结构说明书
本着追本溯源，拒绝浅尝辄止的学习目的，（几乎）所有专栏会按照三步曲进行展开：
1. 基础：万丈高楼平地起。深入了解其设计理念、架构思想、组件功能、API设计
2. 进阶：协同进阶以拔高。高级功能、和其它组件/框架协同使用
3. 应用：智能整合供应用。如何智能化、简单化供给开发者使用，是一个产品的外观

三步曲体现在工程目录上如下结构所示：
```
|-- tech-column-learning
    |-- cors // 专栏名
    |   |-- cors-java
    |   |-- cors-spring-ramework
    |   |-- cors-spring-boot
    |-- xxx // 专栏名
    |   |-- xxx-java
    |   |-- xxx-spring-ramework
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
    

## 使用说明书
这里列出专题列表和源码工程的**对应关系**，方便您的阅读。
> 随着专栏的新增（or搬迁），该列表会定期更新。建议start/Fork/clone此项目，保持最新状态

| 序号 | 专栏名称                                      | 源码目录 |
| :--: | --------------------------------------------- | ------------------------------------------------------------ |
| 【7】 | 点拨-Bean Validation | - |
| 【8】 | 点拨-日期时间 | - |
| 【9】 | 点拨-Spring类型转换 | - |
| 【10】 | 点拨-Spring static | - |
| 【11】 | 点拨-Cors跨域 | - |
| 【12】 | 点拨-Jackson | - |
| 【13】 | 点拨-Spring配置类 | - |
| 【14】 | 点拨-Spring技术栈 | - |
| 【15】 | 点拨-JDK | - |
| 【16】 | 点拨-Servlet | [foundation]() |


