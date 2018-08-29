package com.tricks4live.controller;

import com.tricks4live.annotation.ErrCode;
import com.tricks4live.annotation.Status;
import com.tricks4live.entries.ContentPraise;
import com.tricks4live.entries.Page;
import com.tricks4live.entries.Subject;
import com.tricks4live.entries.result.BaseResult;
import com.tricks4live.entries.result.DataResult;
import com.tricks4live.services.ISubjectService;
import com.tricks4live.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    ISubjectService service;

    @RequestMapping("/findByPage")
    @ResponseBody
    public DataResult<Page<Subject>> findByPage(@RequestParam("category_id") Long categoryId,
                                                @RequestParam("page_num") Long pageNum,
                                                @RequestParam(name = "page_size", defaultValue = "20",
                                                        required = false) Integer pageSize) {
        if (categoryId == null || categoryId < 1) {
            categoryId = 3L;
        }
        if (pageNum == null || pageNum < 1) {
            pageNum = 1L;
        }
        Page<Subject> subjectPage = service.findByPageInCategory(categoryId, pageNum, pageSize);
        return new DataResult<>(subjectPage);
    }

    @RequestMapping("/findById")
    @ResponseBody
    public DataResult<Subject> findById(@RequestParam("subject_id") Long subjectId) {
        DataResult<Subject> result = new DataResult<>();
        if (subjectId == null || subjectId == 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "subject id");
            result.setStatus(Status.FAIL);
            return result;
        }
        result.setData(service.findById(subjectId));
        return result;
    }

    @PostMapping(value = "/addSubject", headers = Constants.HEADER, produces = Constants.APPLICATION_JSON)
    @ResponseBody
    public BaseResult addSubject(@RequestBody Subject subject) {
        BaseResult result = new BaseResult();
        Long id = service.addSubject(subject);
        if (id <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.UNKNOWN));
            result.setStatus(Status.FAIL);
        }
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public BaseResult deleteSubject(@RequestParam("subject_id") Long subjectId) {
        BaseResult result = new BaseResult();
        if (subjectId == null || subjectId == 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "subject id");
            result.setStatus(Status.FAIL);
            return result;
        }
        service.deleteSubject(subjectId);
        return result;
    }

    @RequestMapping("/valid")
    @ResponseBody
    public BaseResult validUser(@RequestParam("subject_id") Long subjectId,
                                @RequestParam("user_id") Long userId,
                                @RequestParam("valid") Boolean valid) {
        BaseResult result = new BaseResult();
        if (subjectId == null || subjectId == 0 || userId == null || userId == 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "subject id or user id");
            result.setStatus(Status.FAIL);
            return result;
        }
        if (valid == null) {
            valid = true;
        }
        Long id = service.validUser(subjectId, userId, valid);
        if (id <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.UNKNOWN));
            result.setStatus(Status.FAIL);
        }
        return result;
    }

    @RequestMapping("/invalid")
    @ResponseBody
    public BaseResult invalidUser(@RequestParam("subject_id") Long subjectId,
                                  @RequestParam("user_id") Long userId,
                                  @RequestParam("invalid") Boolean invalid) {
        BaseResult result = new BaseResult();
        if (subjectId == null || subjectId == 0 || userId == null || userId == 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "subject id or user id");
            result.setStatus(Status.FAIL);
            return result;
        }
        if (invalid == null) {
            invalid = true;
        }
        Long id = service.invalidUser(subjectId, userId, invalid);
        if (id <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.UNKNOWN));
            result.setStatus(Status.FAIL);
        }
        return result;
    }

    @RequestMapping("/findValidUsers")
    @ResponseBody
    public DataResult<Page<ContentPraise>> findValidUsersByPage(@RequestParam("subject_id") Long subjectId,
                                                                @RequestParam("page_num") Long pageNum,
                                                                @RequestParam(name = "page_size", defaultValue = "20",
                                                                        required = false) Integer pageSize) {
        DataResult<Page<ContentPraise>> result = new DataResult<>();
        if (subjectId == null || subjectId == 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "subject id");
            result.setStatus(Status.FAIL);
            return result;
        }
        if (pageNum == null || pageNum < 1) {
            pageNum = 1L;
        }
        Page<ContentPraise> praisePage = service.findValidUsersByPage(subjectId, pageNum, pageSize);
        result.setData(praisePage);
        return result;
    }

    @RequestMapping("/findInvalidUsers")
    @ResponseBody
    public DataResult<Page<ContentPraise>> findInvalidUsersByPage(@RequestParam("subject_id") Long subjectId,
                                                                  @RequestParam("page_num") Long pageNum,
                                                                  @RequestParam(name = "page_size", defaultValue = "20",
                                                                          required = false) Integer pageSize) {
        DataResult<Page<ContentPraise>> result = new DataResult<>();
        if (subjectId == null || subjectId == 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "subject id");
            result.setStatus(Status.FAIL);
            return result;
        }
        if (pageNum == null || pageNum < 1) {
            pageNum = 1L;
        }
        Page<ContentPraise> praisePage = service.findInvalidUsersByPage(subjectId, pageNum, pageSize);
        result.setData(praisePage);
        return result;
    }

    @RequestMapping("/addVerifier")
    @ResponseBody
    public BaseResult addVerifier(@RequestParam("subject_id") Long subjectId,
                                  @RequestParam("user_id") Long userId) {
        BaseResult result = new BaseResult();
        if (subjectId == null || subjectId == 0 || userId == null || userId == 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "subject id or user id");
            result.setStatus(Status.FAIL);
            return result;
        }
        Long id = service.addVerifier(subjectId, userId);
        if (id <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.UNKNOWN));
            result.setStatus(Status.FAIL);
        }
        return result;
    }

    @RequestMapping("/updateVerifier")
    @ResponseBody
    public BaseResult updateVerifier(@RequestParam("subject_id") Long subjectId,
                                     @RequestParam("user_id") Long userId,
                                     @RequestParam("valid") Boolean valid) {
        BaseResult result = new BaseResult();
        if (subjectId == null || subjectId == 0 || userId == null || userId == 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "subject id or user id");
            result.setStatus(Status.FAIL);
            return result;
        }
        if (valid == null) {
            valid = false;
        }
        Long id = service.updateVerifier(subjectId, userId, valid);
        if (id <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.UNKNOWN));
            result.setStatus(Status.FAIL);
        }
        return result;
    }

    @RequestMapping("/findVerifier")
    @ResponseBody
    public DataResult<Page<ContentPraise>> findVerifier(@RequestParam("subject_id") Long subjectId,
                                                        @RequestParam("page_num") Long pageNum,
                                                        @RequestParam(name = "page_size", defaultValue = "20",
                                                                required = false) Integer pageSize) {
        DataResult<Page<ContentPraise>> result = new DataResult<>();
        if (subjectId == null || subjectId == 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "subject id");
            result.setStatus(Status.FAIL);
            return result;
        }
        if (pageNum == null || pageNum < 1) {
            pageNum = 1L;
        }
        Page<ContentPraise> praisePage = service.findVerifierByPage(subjectId, pageNum, pageSize);
        result.setData(praisePage);
        return result;
    }

    @RequestMapping("/collect")
    @ResponseBody
    public BaseResult collectSubject(@RequestParam("subject_id") Long subjectId,
                                     @RequestParam("user_id") Long userId,
                                     @RequestParam("collected") Boolean collected) {
        BaseResult result = new BaseResult();
        if (subjectId == null || subjectId == 0 || userId == null || userId == 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "subject id or user id");
            result.setStatus(Status.FAIL);
            return result;
        }
        if (collected == null) {
            collected = false;
        }
        Long id = service.collectSubject(subjectId, userId, collected);
        if (id <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.UNKNOWN));
            result.setStatus(Status.FAIL);
        }
        return result;
    }

    @RequestMapping("/findCollected")
    @ResponseBody
    public DataResult<Page<Subject>> findCollected(@RequestParam("user_id") Long userId,
                                                   @RequestParam("page_num") Long pageNum,
                                                   @RequestParam("page_size") Integer pageSize) {
        DataResult<Page<Subject>> result = new DataResult<>();
        if (userId == null || userId == 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "user id");
            result.setStatus(Status.FAIL);
            return result;
        }
        if (pageNum == null || pageNum < 1) {
            pageNum = 1L;
        }
        Page<Subject> subjectPage = service.findCollectedByPage(userId, pageNum, pageSize);
        result.setData(subjectPage);
        return result;
    }
}
