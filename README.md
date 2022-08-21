# xinyuan-seckill
基于spring-boot的秒杀模块 集成mybatis-plus,Redis,postgresql

前端技术:
thymeleaf模板(后期分离可弃用)
bootstarp框架
jquery

后端技术:
springboot
mybatis-plus
lombok
devtools

数据库:
postgresql


坑:
1.数据库建表时商品价格的数据类型切记不要用money类型,要使用numeric加需要数据精度才不会使数据丢失!

2.接收数据库数据时,需要使用BigDecimal类型,否则会容易导致数据精度丢失!

3.redis缓存中存储用户对象可以增强项目性能,规避了重复验证,后续要添加静态化页面到redis缓存中

4.md5加密验证需要前后端同时进行加密,使用的盐(salt)需一致,本项目中共进行两次加密,第一次为前端到服务端,第二次为服务端到数据库

5.其他类型的小坑均在项目中有大量注释

持续更新中...


