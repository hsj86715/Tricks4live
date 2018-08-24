package com.tricks4live.services.impl;

import com.tricks4live.LogAbleClass;
import com.tricks4live.entries.User;
import com.tricks4live.mappers.UserMapper;
import com.tricks4live.services.IUserService;
import com.tricks4live.utils.EncryptUtil;
import com.tricks4live.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends LogAbleClass implements IUserService {

    @Autowired
    UserMapper mapper;

    @Override
    public boolean userNameUsable(String userName) {
        User user = mapper.findByUserName(userName);
        println("userNameUsable", user);
        return user == null;
    }

    @Override
    public boolean emailUsable(String email) {
        User user = mapper.findByEmail(email);
        println("emailUsable", user);
        return user == null;
    }

    @Override
    public boolean phoneUsable(String phone) {
        User user = mapper.findByPhone(phone);
        println("phoneUsable", user);
        return user == null;
    }

    @Override
    public User register(User user, String userAgent) {
        user.setPassword(EncryptUtil.encryptPassword(user.getPassword()));
        user.setToken(TokenUtil.createJWT(user, userAgent));
        user.setRegisterDate(new Date());
        mapper.addUser(user);
        println("register", user);
        return user;
    }

    @Override
    public User login(String userName, String password, String userAgent) {
        password = EncryptUtil.encryptPassword(password);
        User user = mapper.login(new User(userName, password));
        if (user != null) {
            user.setToken(TokenUtil.createJWT(user, userAgent));
            mapper.updateToken(user);
        }
        println("login", user);
        return user;
    }

    @Override
    public User changePassword(User user, String oldpwd, String newpwd) {
        return null;
    }

    @Override
    public void forgetPassword(String userName, String email) {

    }

    @Override
    public void findBackPassword(String token, String newpwd) {

    }

    @Override
    public List<User> findAll() {
        List<User> users = mapper.findAll();
        println("findAll", users);
        return users;
    }
}
