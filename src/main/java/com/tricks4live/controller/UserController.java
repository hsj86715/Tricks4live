package com.tricks4live.controller;

import com.tricks4live.annotation.ErrCode;
import com.tricks4live.annotation.Status;
import com.tricks4live.enrties.User;
import com.tricks4live.enrties.result.BaseResult;
import com.tricks4live.enrties.result.DataResult;
import com.tricks4live.enrties.result.UserCheckResult;
import com.tricks4live.services.IUserService;
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
            result.setCode(ErrCode.REQUEST_PARAMETER_LOST);
            result.setStatus(Status.FAIL);
            result.setMsg("The request userName must not be empty");
            return result;
        }

        Boolean usable = userService.userNameUsable(userName);
        result.setUsable(usable);
        if (usable) {
            result.setCode(ErrCode.USER_NOT_EXISTS);
            result.setMsg("The userName: " + userName + " is usable.");
        } else {
            result.setCode(ErrCode.USERNAME_OCCUPIED);
            result.setMsg("The userName: " + userName + " has been occupied.");
        }
        return result;
    }

    @RequestMapping("/check_email")
    @ResponseBody
    public BaseResult isEmailUsable(@RequestParam("email") String email) {
        UserCheckResult result = new UserCheckResult();
        if (StringUtils.isEmpty(email)) {
            result.setCode(ErrCode.REQUEST_PARAMETER_LOST);
            result.setStatus(Status.FAIL);
            result.setMsg("The request email must not be empty");
            return result;
        }

        Boolean usable = userService.emailUsable(email);
        result.setUsable(usable);
        if (usable) {
            result.setMsg("The email: " + email + " is usable.");
        } else {
            result.setCode(ErrCode.EMAIL_OCCUPIED);
            result.setMsg("The email: " + email + " has been occupied.");
        }
        return result;
    }

    @RequestMapping("/check_phone")
    @ResponseBody
    public BaseResult isPhoneUsable(@RequestParam("phone") String phone) {
        UserCheckResult result = new UserCheckResult();
        if (StringUtils.isEmpty(phone)) {
            result.setCode(ErrCode.REQUEST_PARAMETER_LOST);
            result.setStatus(Status.FAIL);
            result.setMsg("The request phone must not be empty");
            return result;
        }

        Boolean usable = userService.phoneUsable(phone);
        result.setUsable(usable);
        if (usable) {
            result.setMsg("The phone: " + phone + " is usable.");
        } else {
            result.setCode(ErrCode.PHONE_OCCUPIED);
            result.setMsg("The phone: " + phone + " has been occupied.");
        }
        return result;
    }

    @PostMapping("/register")
    @ResponseBody
    public BaseResult register(@RequestBody User user, HttpServletRequest request) {
        BaseResult result = new BaseResult();

        if (StringUtils.isEmpty(user.getUserName())) {
            result.setCode(ErrCode.EMPTY_USERNAME);
            result.setMsg("The request userName must not be empty");
            result.setStatus(Status.FAIL);
        } else if (StringUtils.isEmpty(user.getPassword())) {
            result.setCode(ErrCode.EMPTY_PWD);
            result.setMsg("The request password must not be empty");
            result.setStatus(Status.FAIL);
        } else if (StringUtils.isEmpty(user.getEmail())) {
            result.setCode(ErrCode.EMPTY_EMAIL);
            result.setMsg("The request email must not be empty");
            result.setStatus(Status.FAIL);
        } else {
            String password = user.getPassword();
            if (password.length() < 6) {
                result.setCode(ErrCode.PWD_SHORT);
                result.setMsg("The request password is too short, the suggested minimal length is 6");
                result.setStatus(Status.FAIL);
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

//    @RequestMapping(name = "/login", method = RequestMethod.POST)
    @PostMapping("/login")
    @ResponseBody
    public BaseResult login(String userName, String password, HttpServletRequest request) {
        BaseResult result = new BaseResult();

        if (StringUtils.isEmpty(userName)) {
            result.setCode(ErrCode.EMPTY_USERNAME);
            result.setMsg("The request userName must not be empty");
            result.setStatus(Status.FAIL);
        } else if (StringUtils.isEmpty(password)) {
            result.setCode(ErrCode.EMPTY_PWD);
            result.setMsg("The request password must not be empty");
            result.setStatus(Status.FAIL);
        } else {
            String userAgent = request.getHeader("User-Agent");
            User user = userService.login(userName, password, userAgent);
            if (user == null) {
                result.setCode(ErrCode.USERNAME_OR_PWD_ERR);
                result.setMsg("The userName or password is not right for login");
                result.setStatus(Status.FAIL);
            } else {
                result = new DataResult<User>();
                result.setMsg("User login successful");
                ((DataResult) result).setData(user);
            }
        }
        return result;
    }
}
