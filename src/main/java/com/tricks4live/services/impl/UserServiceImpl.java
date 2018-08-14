package com.tricks4live.services.impl;

import com.tricks4live.enrties.User;
import com.tricks4live.repositories.UserRepository;
import com.tricks4live.services.IUserService;
import com.tricks4live.utils.EncryptUtil;
import com.tricks4live.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository repository;

    @Override
    public boolean userNameUsable(String userName) {
        User user = repository.findByUserName(userName);
        return user == null;
    }

    @Override
    public boolean emailUsable(String email) {
        User user = repository.findByEmail(email);
        return user == null;
    }

    @Override
    public boolean phoneUsable(String phone) {
        User user = repository.findByPhone(phone);
        return user == null;
    }

    @Override
    public User register(User user, String userAgent) {
        user.setPassword(EncryptUtil.encryptPassword(user.getPassword()));
        user.setToken(TokenUtil.createJWT(user, userAgent));
        return repository.save(user);
    }

    @Override
    public User login(String userName, String password, String userAgent) {
        password = EncryptUtil.encryptPassword(password);
        User user = repository.findByUsernameAndPassword(userName, password);
        if (user != null) {
            user.setToken(TokenUtil.createJWT(user, userAgent));
            user.setLastLoginDate(new Date());
            repository.save(user);
        }
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
    public void findbackPassword(String token, String newpwd) {

    }
}
