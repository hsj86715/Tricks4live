package com.tricks4live.mappers;

import com.tricks4live.entries.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    List<User> findAll();

    User findByUserName(String userName);

    User findByEmail(String email);

    User findByPhone(String phone);

    User findById(Long userId);

    List<User> findByNickName(String nickName);

    void addUser(User user);

    User login(User user);

    void loginOut(String token);

    void deleteById(Long userId);

    void updateToken(User user);
}
