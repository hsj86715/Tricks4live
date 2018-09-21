package com.tricks4live.services.impl;

import com.tricks4live.annotation.Authority;
import com.tricks4live.annotation.PraiseType;
import com.tricks4live.entries.ContentPraise;
import com.tricks4live.entries.User;
import com.tricks4live.exception.EmailNotVerifiedException;
import com.tricks4live.mappers.UserMapper;
import com.tricks4live.services.IUserService;
import com.tricks4live.utils.EncryptUtil;
import com.tricks4live.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends PraiseAbleService implements IUserService {

    @Autowired
    private UserMapper mapper;

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
//        user.setToken(TokenUtil.createJWT(user, userAgent));
        user.setCreateDate(new Date());
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
    public void loginOut(String token) {
        mapper.loginOut(token);
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

    @Override
    public Boolean isFocused(Long whichUser, Long focusWho) {
        ContentPraise praise = new ContentPraise(whichUser, focusWho, PraiseType.FOCUS_USER);
        ContentPraise praiseTemp = praiseMapper.findPraise(praise);
        if (praiseTemp == null || praiseTemp.getPraised() == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE == praiseTemp.getPraised();
    }

    @Override
    public Long focusUser(Long whichUser, Long focusWho, Boolean focused) throws EmailNotVerifiedException {
        User user = findUserById(whichUser);
        if (!user.hasPermission(Authority.BASE)) {
            throw new EmailNotVerifiedException();
        }
        ContentPraise praise = new ContentPraise(whichUser, focusWho, PraiseType.FOCUS_USER);
        return setPraised(praise, focused);
    }

    @Override
    public User findUserById(Long userId) {
        return mapper.findById(userId);
    }
}
