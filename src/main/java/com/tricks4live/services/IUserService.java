package com.tricks4live.services;

import com.tricks4live.entries.User;

import java.util.List;

public interface IUserService {

    boolean userNameUsable(String userName);

    boolean emailUsable(String email);

    boolean phoneUsable(String phone);

    User register(User user, String userAgent);

    User login(String userName, String password, String userAgent);

    User changePassword(User user, String oldpwd, String newpwd);

    void forgetPassword(String userName, String email);

    void findBackPassword(String token, String newpwd);

    List<User> findAll();
}
