package com.tricks4live.controller;

import com.tricks4live.annotation.ErrCode;
import com.tricks4live.entries.Page;
import com.tricks4live.entries.SubjectInfo;
import com.tricks4live.entries.UserSimple;
import com.tricks4live.entries.result.BaseResult;
import com.tricks4live.entries.result.DataResult;
import com.tricks4live.exception.EmailNotVerifiedException;
import com.tricks4live.exception.PermissionException;
import com.tricks4live.services.ISubjectService;
import com.tricks4live.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private ISubjectService service;

    @RequestMapping("/findByPage")
    public DataResult<Page<SubjectInfo>> findByPage(@RequestParam("category_id") Long categoryId,
                                                    @RequestParam("page_num") Long pageNum,
                                                    @RequestParam(name = "page_size", defaultValue = "20",
                                                            required = false) Integer pageSize) {
        DataResult<Page<SubjectInfo>> result = new DataResult<>();
        if (categoryId <= 0 || pageNum < 1) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "category_id or/and page_num");
            return result;
        }
        Page<SubjectInfo> subjectPage = service.findByPageInCategory(categoryId, pageNum, pageSize);
        result.setData(subjectPage);
        return result;
    }

    @RequestMapping("/findById")
    public DataResult<SubjectInfo> findById(@RequestParam("subject_id") Long subjectId,
                                            @RequestParam(name = "user_id", required = false) Long userId) {
        DataResult<SubjectInfo> result = new DataResult<>();
        if (subjectId <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "subject_id");
            return result;
        }
        result.setData(service.findById(subjectId, userId));
        return result;
    }

    @PostMapping(value = "/addSubject", headers = Constants.HEADER, produces = Constants.APPLICATION_JSON)
    public BaseResult addSubject(@RequestBody SubjectInfo subject) {
        BaseResult result = new BaseResult();
        Long id = service.addSubject(subject);
        if (id <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.UNKNOWN));
        }
        return result;
    }

    @RequestMapping("/delete")
    public BaseResult deleteSubject(@RequestParam("subject_id") Long subjectId) {
        BaseResult result = new BaseResult();
        if (subjectId <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "subject_id");
            return result;
        }
        service.deleteSubject(subjectId);
        return result;
    }

    @GetMapping("/validate")
    public BaseResult validUser(@RequestParam("subject_id") Long subjectId,
                                @RequestParam("user_id") Long userId,
                                @RequestParam("validated") Boolean validated) {
        BaseResult result = new BaseResult();
        if (subjectId <= 0 || userId <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "subject_id or/and user_id");
            return result;
        }
        try {
            Long id = service.validUser(subjectId, userId, validated);
            if (id <= 0) {
                result.setCodeMsg(Constants.getErrorMsg(ErrCode.UNKNOWN));
            }
        } catch (EmailNotVerifiedException e) {
            e.printStackTrace();
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.EMAIL_NEED_VERIFY));
        }
        return result;
    }

    @GetMapping("/invalidate")
    public BaseResult invalidUser(@RequestParam("subject_id") Long subjectId,
                                  @RequestParam("user_id") Long userId,
                                  @RequestParam("invalidated") Boolean invalidated) {
        BaseResult result = new BaseResult();
        if (subjectId <= 0 || userId <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "subject_id or/and user_id");
            return result;
        }
        try {
            Long id = service.invalidUser(subjectId, userId, invalidated);
            if (id <= 0) {
                result.setCodeMsg(Constants.getErrorMsg(ErrCode.UNKNOWN));
            }
        } catch (EmailNotVerifiedException e) {
            e.printStackTrace();
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.EMAIL_NEED_VERIFY));
        }
        return result;
    }

    @RequestMapping("/findValidUsers")
    public DataResult<Page<UserSimple>> findValidUsersByPage(@RequestParam("subject_id") Long subjectId,
                                                             @RequestParam("page_num") Long pageNum,
                                                             @RequestParam(name = "page_size", defaultValue = "20",
                                                                     required = false) Integer pageSize) {
        DataResult<Page<UserSimple>> result = new DataResult<>();
        if (subjectId <= 0 || pageNum < 1) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "subject_id or/and page_num");
            return result;
        }
        Page<UserSimple> praisePage = service.findValidUsersByPage(subjectId, pageNum, pageSize);
        result.setData(praisePage);
        return result;
    }

    @RequestMapping("/findInvalidUsers")
    public DataResult<Page<UserSimple>> findInvalidUsersByPage(@RequestParam("subject_id") Long subjectId,
                                                               @RequestParam("page_num") Long pageNum,
                                                               @RequestParam(name = "page_size", defaultValue = "20",
                                                                       required = false) Integer pageSize) {
        DataResult<Page<UserSimple>> result = new DataResult<>();
        if (subjectId <= 0 || pageNum < 1) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "subject_id or/and page_num");
            return result;
        }
        Page<UserSimple> praisePage = service.findInvalidUsersByPage(subjectId, pageNum, pageSize);
        result.setData(praisePage);
        return result;
    }

    @RequestMapping("/addVerifier")
    public BaseResult addVerifier(@RequestParam("subject_id") Long subjectId,
                                  @RequestParam("user_id") Long userId) {
        BaseResult result = new BaseResult();
        if (subjectId <= 0 || userId <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "subject_id or/and user_id");
            return result;
        }
        try {
            Long id = service.addVerifier(subjectId, userId);
            if (id <= 0) {
                result.setCodeMsg(Constants.getErrorMsg(ErrCode.UNKNOWN));
            }
        } catch (PermissionException e) {
            e.printStackTrace();
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.PERMISSION_PROHIBITED));
        }
        return result;
    }

    @RequestMapping("/updateVerifier")
    public BaseResult updateVerifier(@RequestParam("subject_id") Long subjectId,
                                     @RequestParam("user_id") Long userId,
                                     @RequestParam("valid") Boolean valid) {
        BaseResult result = new BaseResult();
        if (subjectId <= 0 || userId <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "subject_id or/and user_id");
            return result;
        }
        Long id = service.updateVerifier(subjectId, userId, valid);
        if (id <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.UNKNOWN));
        }
        return result;
    }

    @RequestMapping("/findVerifier")
    public DataResult<Page<UserSimple>> findVerifier(@RequestParam("subject_id") Long subjectId,
                                                     @RequestParam("page_num") Long pageNum,
                                                     @RequestParam(name = "page_size", defaultValue = "20",
                                                             required = false) Integer pageSize) {
        DataResult<Page<UserSimple>> result = new DataResult<>();
        if (subjectId == 0 || pageNum < 1) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "subject_id or/and page_num");
            return result;
        }
        Page<UserSimple> praisePage = service.findVerifierByPage(subjectId, pageNum, pageSize);
        result.setData(praisePage);
        return result;
    }

    @GetMapping("/collect")
    public BaseResult collectSubject(@RequestParam("subject_id") Long subjectId,
                                     @RequestParam("user_id") Long userId,
                                     @RequestParam("collected") Boolean collected) {
        BaseResult result = new BaseResult();
        if (subjectId <= 0 || userId <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "subject_id or/and user_id");
            return result;
        }
        try {
            Long id = service.collectSubject(subjectId, userId, collected);
            if (id <= 0) {
                result.setCodeMsg(Constants.getErrorMsg(ErrCode.UNKNOWN));
            }
        } catch (EmailNotVerifiedException e) {
            e.printStackTrace();
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.EMAIL_NEED_VERIFY));
        }
        return result;
    }

    @RequestMapping("/findCollected")
    public DataResult<Page<SubjectInfo>> findCollected(@RequestParam("user_id") Long userId,
                                                       @RequestParam("page_num") Long pageNum,
                                                       @RequestParam(name = "page_size", defaultValue = "20",
                                                               required = false) Integer pageSize) {
        DataResult<Page<SubjectInfo>> result = new DataResult<>();
        if (userId <= 0 || pageNum < 1) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "user_id or/and page_num");
            return result;
        }
        Page<SubjectInfo> subjectPage = service.findCollectedByPage(userId, pageNum, pageSize);
        result.setData(subjectPage);
        return result;
    }

    @RequestMapping("/findNewest")
    public DataResult<Page<SubjectInfo>> findNewest(@RequestParam("page_num") Long pageNum,
                                                    @RequestParam(name = "page_size", defaultValue = "20",
                                                            required = false) Integer pageSize) {
        DataResult<Page<SubjectInfo>> result = new DataResult<>();
        if (pageNum < 1) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "page_num");
            return result;
        }
        Page<SubjectInfo> subjectPage = service.findByPageForNewest(pageNum, pageSize);
        result.setData(subjectPage);
        return result;
    }

    @RequestMapping("/findMyPublish")
    public DataResult<Page<SubjectInfo>> findMyPublish(@RequestParam("user_id") Long userId,
                                                       @RequestParam("page_num") Long pageNum,
                                                       @RequestParam(name = "page_size", defaultValue = "20",
                                                               required = false) Integer pageSize) {
        DataResult<Page<SubjectInfo>> result = new DataResult<>();
        if (userId <= 0 || pageNum < 1) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "user_id or/and page_num");
            return result;
        }
        Page<SubjectInfo> subjectPage = service.findUserPublishByPage(userId, pageNum, pageSize);
        result.setData(subjectPage);
        return result;
    }
}
