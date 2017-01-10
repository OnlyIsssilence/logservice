package com.onlyisssilence.muya;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Author: MuYa
 * Date  : 2017/1/10
 * Description:另一种测试基础类实现
 */
public class SpringBaseTest {

    public static final ClassPathXmlApplicationContext applicationContext
            = new ClassPathXmlApplicationContext("META-INF/spring/*.xml");

    @BeforeClass
    public static void beforeClass() {

    }

    @AfterClass
    public static void afterClass() {
        applicationContext.destroy();
    }

    @Test
    public void test() throws SQLException {
        /*LoginAction loginAction = applicationContext.getBean(LoginAction.class);
        assert loginAction != null;
        LoginService loginService=applicationContext.getBean(LoginService.class);
        loginService.isUserExists("abc1");*/
    }
}
