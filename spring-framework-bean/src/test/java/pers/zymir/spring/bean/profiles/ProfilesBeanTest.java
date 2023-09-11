package pers.zymir.spring.bean.profiles;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@ContextConfiguration(classes = ProfileBeanConfig.class)
@RunWith(SpringRunner.class)
public class ProfilesBeanTest {

    @Autowired
    private ProfileBeanConfig.MySQLConfig sqlConfig;
    @Autowired
    private Environment environment;

    @Test
    public void profilesTest() {
        List<String> activeProfiles = Arrays.asList(environment.getActiveProfiles());
        if (activeProfiles.contains("test") || activeProfiles.contains("dev")) {
            Assert.assertTrue("root".equals(sqlConfig.getUsername()));
        } else {
            Assert.assertTrue("stage-read-only".equals(sqlConfig.getUsername()));
        }
    }
}
