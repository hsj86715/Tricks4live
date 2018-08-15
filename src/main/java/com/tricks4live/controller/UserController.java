package com.tricks4live.controller;

import com.tricks4live.annotation.ErrCode;
import com.tricks4live.annotation.Status;
import com.tricks4live.enrties.User;
import com.tricks4live.enrties.result.BaseResult;
import com.tricks4live.enrties.result.DataResult;
import com.tricks4live.enrties.result.UserCheckResult;
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
    public BaseResult isUserNameUsable(@RequestParam("userName") String userName) {
        UserCheckResult result = new UserCheckResult();
        if (StringUtils.isEmpty(userName)) {
            result.setStatus(Status.FAIL);
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "userName");
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
            result.setStatus(Status.FAIL);
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
            result.setStatus(Status.FAIL);
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
    public BaseResult register(@RequestBody User user, HttpServletRequest request) {
        BaseResult result = new BaseResult();

        if (StringUtils.isEmpty(user.getUserName())) {
            result.setStatus(Status.FAIL);
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.EMPTY_USERNAME));
        } else if (StringUtils.isEmpty(user.getPassword())) {
            result.setStatus(Status.FAIL);
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.EMPTY_PWD));
        } else if (StringUtils.isEmpty(user.getEmail())) {
            result.setStatus(Status.FAIL);
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.EMPTY_EMAIL));
        } else {
            String password = user.getPassword();
            if (password.length() < 6) {
                result.setStatus(Status.FAIL);
                result.setCodeMsg(Constants.getErrorMsg(ErrCode.PWD_SHORT));
            } else {
                result = new DataResult<User>();
                String userAgent = request.getHeader("User-Agent");
                User u = userService.register(user, userAgent);
                result.setMsg("User registered successful");
                ((DataResult) result).setData(u);
            }
        }
        return result;
    }

    @PostMapping("/login")
    @ResponseBody
    public BaseResult login(String userName, String password, HttpServletRequest request) {
        BaseResult result = new BaseResult();

        if (StringUtils.isEmpty(userName)) {
            result.setStatus(Status.FAIL);
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.EMPTY_USERNAME));
        } else if (StringUtils.isEmpty(password)) {
            result.setStatus(Status.FAIL);
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.EMPTY_PWD));
        } else {
            String userAgent = request.getHeader("User-Agent");
            User user = userService.login(userName, password, userAgent);
            if (user == null) {
                result.setStatus(Status.FAIL);
                result.setCodeMsg(Constants.getErrorMsg(ErrCode.USERNAME_OR_PWD_ERR));
            } else {
                result = new DataResult<User>();
                result.setMsg("User login successful");
                ((DataResult) result).setData(user);
            }
        }
        return result;
    }
}
