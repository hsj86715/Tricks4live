package com.tricks4live.controller;

import com.tricks4live.annotation.ErrCode;
import com.tricks4live.entries.User;
import com.tricks4live.entries.result.BaseResult;
import com.tricks4live.entries.result.DataResult;
import com.tricks4live.entries.result.UserCheckResult;
import com.tricks4live.services.IUserService;
import com.tricks4live.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping("/check_username")
    @ResponseBody
    public BaseResult isUserNameUsable(@RequestParam("user_name") String userName) {
        UserCheckResult result = new UserCheckResult();
        if (StringUtils.isEmpty(userName)) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "user_name");
            return result;
        }

        Boolean usable = userService.userNameUsable(userName);
        result.setUsable(usable);
        if (usable) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.USER_NOT_EXISTS), userName);
        } else {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.USERNAME_OCCUPIED), userName);
        }
        return result;
    }

    @RequestMapping("/check_email")
    @ResponseBody
    public BaseResult isEmailUsable(@RequestParam("email") String email) {
        UserCheckResult result = new UserCheckResult();
        if (StringUtils.isEmpty(email)) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "email");
            return result;
        }

        Boolean usable = userService.emailUsable(email);
        result.setUsable(usable);
        if (usable) {
            result.setMsg("The email: " + email + " is usable.");
        } else {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.EMAIL_OCCUPIED), email);
        }
        return result;
    }

    @RequestMapping("/check_phone")
    @ResponseBody
    public BaseResult isPhoneUsable(@RequestParam("phone") String phone) {
        UserCheckResult result = new UserCheckResult();
        if (StringUtils.isEmpty(phone)) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "phone");
            return result;
        }

        Boolean usable = userService.phoneUsable(phone);
        result.setUsable(usable);
        if (usable) {
            result.setMsg("The phone: " + phone + " is usable.");
        } else {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.PHONE_OCCUPIED), phone);
        }
        return result;
    }

    @PostMapping("/register")
    @ResponseBody
    public DataResult<User> register(@RequestBody User user, HttpServletRequest request) {
        DataResult<User> result = new DataResult<>();

        if (StringUtils.isEmpty(user.getUserName())) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.EMPTY_USERNAME));
        } else if (StringUtils.isEmpty(user.getPassword())) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.EMPTY_PWD));
        } else if (StringUtils.isEmpty(user.getEmail())) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.EMPTY_EMAIL));
        } else {
            String password = user.getPassword();
            if (password.length() < 6) {
                result.setCodeMsg(Constants.getErrorMsg(ErrCode.PWD_SHORT));
            } else {
                String userAgent = request.getHeader("User-Agent");
                user = userService.register(user, userAgent);
                result.setData(user);
            }
        }
        return result;
    }

    @PostMapping("/login")
    @ResponseBody
    public DataResult<User> login(String userName, String password, HttpServletRequest request) {
        DataResult<User> result = new DataResult<>();

        if (StringUtils.isEmpty(userName)) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.EMPTY_USERNAME));
        } else if (StringUtils.isEmpty(password)) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.EMPTY_PWD));
        } else {
            String userAgent = request.getHeader("User-Agent");
            User user = userService.login(userName, password, userAgent);
            if (user == null) {
                result.setCodeMsg(Constants.getErrorMsg(ErrCode.USERNAME_OR_PWD_ERR));
            } else {
                result.setMsg("User login successful");
                result.setData(user);
            }
        }
        return result;
    }
}
