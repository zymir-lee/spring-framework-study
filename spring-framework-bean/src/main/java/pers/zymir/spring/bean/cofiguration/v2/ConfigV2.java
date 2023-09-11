package pers.zymir.spring.bean.cofiguration.v2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigV2 {

    @Bean
    public ChildBean childBean() {
        return new ChildBean();
    }

    @Bean
    public ParentBean parentBean(ChildBean childBean) {
        // 默认按照需要的类型进行自动注入，spring会到上下文寻找ChildBean类型的bean注入进来
        return new ParentBean(childBean);
    }

    // @Bean 推荐使用上面的装配方式
    public ParentBean parentBean2() {
        // spring会拦截childBean()方法的调用 并且返回上下文中的bean
        // 这种方式可能产生迷惑不推荐使用
        return new ParentBean(childBean());
    }

}
