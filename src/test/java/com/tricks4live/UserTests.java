package com.tricks4live;

import com.tricks4live.enrties.User;
import com.tricks4live.services.IUserService;
import com.tricks4live.utils.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {
    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(UserTests.this.getClass().getTypeName());
    @Autowired
    IUserService userService;

    @Test
    public void testUserNameUsable() {
        String userName = "user_46A5";
        Boolean usable = userService.userNameUsable(userName);
        assert usable == false;
        System.out.println();
        logger.info("testUserNameUsable: " + usable);
        System.out.println();
    }

    @Test
    public void testEmailUsable() {
        String email = "email41@test.com";
        Boolean usable = userService.emailUsable(email);
        assert usable == false;
        System.out.println();
        logger.info("testEmailUsable: " + usable);
        System.out.println();
    }

    @Test
    public void testPhoneUsable() {
        String phone = "13123456789";
        Boolean usable = userService.phoneUsable(phone);
        assert usable == false;
        System.out.println();
        logger.info("testPhoneUsable: " + usable);
        System.out.println();
    }

    @Test
    public void testRegister() {
        User user = new User();
        String uuid = UUIDUtil.getUUID();
        user.setUserName("user_" + uuid.substring(0, 4));
        user.setPassword("pass_" + uuid.substring(4, 8));
        user.setNickName("nick_" + uuid.substring(8, 12));
        user.setId(uuid);
        user.setEmail("email" + uuid.substring(12, 14) + "@test.com");
        user.setPhone("13123456789");
        user.setRegisterDate(new Date());

        System.out.println();
        logger.info("testRegister, user: " + user.toString());
        user = userService.register(user, "Test");
        logger.info("testRegister, user: " + user.toString());
        System.out.println();
    }

    @Test
    public void testLogin() {
        String userName = "user_4519";
        String password = "pass_C50A";
        User user = userService.login(userName, password, "Test");
        assert user != null;
        System.out.println();
        logger.info("testLogin: " + user.toString());
        System.out.println();
    }
}
