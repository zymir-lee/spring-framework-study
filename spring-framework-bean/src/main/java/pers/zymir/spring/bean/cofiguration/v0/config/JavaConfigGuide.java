package pers.zymir.spring.bean.cofiguration.v0.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pers.zymir.spring.bean.cofiguration.v0.beans.BasePackage;

@Configuration
// 默认情况下@ComponentScan将扫描本包以及子包下的类，配置类所在的包就是基础包
// 可以通过basePackages或者basePackageClasses来指定基础包
// @ComponentScan(basePackages = "pers.zymir.spring.bean")
// 使用basePackageClasses，那么这个类所在的包将作为基础包，推荐创建一个空的类来标记基础包的位置；避免包名修改、类迁移带来的错误
@ComponentScan(basePackageClasses = BasePackage.class)
public class JavaConfigGuide {

}
