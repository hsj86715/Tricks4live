package com.tricks4live;

import com.tricks4live.entries.User;
import com.tricks4live.services.IUserService;
import com.tricks4live.utils.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests extends LogAbleClass {
    @Autowired
    IUserService userService;

    @Test
    public void testUserNameUsable() {
        String userName = "user_4f1f";
        Boolean usable = userService.userNameUsable(userName);
        assert usable == false;
        println("testUserNameUsable:", usable);
    }

    @Test
    public void testEmailUsable() {
        String email = "email40@test.com";
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
        user.setEmail("email" + uuid.substring(12, 14) + "@test.com");
        user.setPhone("13123456789");

        println("testRegister BEFORE, user", user.toString());
        user = userService.register(user, "Test");
        println("testRegister AFTER, user", user.toString());
    }

    @Test
    public void testLogin() {
        String userName = "user_4f1f";
        String password = "pass_de9a";
        User user = userService.login(userName, password, "Test");
        assert user != null;
        println("testLogin", user.toString());
    }

    @Test
    public void testFindAll() {
        List<User> users = userService.findAll();
        assert users != null;
        println("testFindAll", users);
    }
}
