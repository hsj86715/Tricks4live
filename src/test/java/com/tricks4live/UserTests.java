package com.tricks4live;

import com.tricks4live.enrties.User;
import com.tricks4live.services.IUserService;
import com.tricks4live.utils.UUIDUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class UserTests extends BaseTest {
    @Autowired
    IUserService userService;

    @Test
    public void testUserNameUsable() {
        String userName = "user_64FB";
        Boolean usable = userService.userNameUsable(userName);
        assert usable == false;
        println("testUserNameUsable:", usable);
    }

    @Test
    public void testEmailUsable() {
        String email = "email41@test.com";
        Boolean usable = userService.emailUsable(email);
        assert usable == false;
        println("testEmailUsable", usable);
    }

    @Test
    public void testPhoneUsable() {
        String phone = "13123456789";
        Boolean usable = userService.phoneUsable(phone);
        assert usable == false;
        println("testPhoneUsable", usable);
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

        println("testRegister, user", user.toString());
        user = userService.register(user, "Test");
        println("testRegister, user", user.toString());
    }

    @Test
    public void testLogin() {
        String userName = "user_64FB";
        String password = "pass_6C9B";
        User user = userService.login(userName, password, "Test");
        assert user != null;
        println("testLogin", user.toString());
    }
}
