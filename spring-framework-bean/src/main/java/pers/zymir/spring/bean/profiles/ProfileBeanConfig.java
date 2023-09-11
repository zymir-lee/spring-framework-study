package pers.zymir.spring.bean.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:env.properties")
public class ProfileBeanConfig {

    public class MySQLConfig {
        private String username;
        private String password;

        public String getPassword() {
            return password;
        }

        public String getUsername() {
            return username;
        }

        public MySQLConfig(String username, String password) {
            this.password = password;
            this.username = username;
        }

        @Override
        public String toString() {
            return username + ";" + password;
        }
    }

    // @Profile也可以配合@Component注解使用 这里不再重复演示

    @Bean
    // test dev环境加载测试环境数据库配置
    @Profile({"test", "dev"})
    public MySQLConfig testMySQLConfig() {
        return new MySQLConfig("root", "root");
    }

    @Bean
    // stage环境加载预发布环境数据库配置
    @Profile("stage")
    public MySQLConfig stageMySQLConfig() {
        return new MySQLConfig("stage-read-only", "stage-read-only");
    }

}
