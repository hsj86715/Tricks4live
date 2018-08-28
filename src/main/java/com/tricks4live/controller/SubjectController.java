package com.tricks4live.controller;

import com.tricks4live.annotation.ErrCode;
import com.tricks4live.annotation.Status;
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
    public DataResult<Page<Subject>> findByPage(@RequestParam("category_id") Long cid, @RequestParam("page_num") Long pageNum,
                                                @RequestParam(name = "page_size", defaultValue = "20") Integer pageSize) {
        if (cid == null || cid < 1) {
            cid = 3L;
        }
        if (pageNum == null || pageNum < 1) {
            pageNum = 1L;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = 20;
        }
        Page<Subject> subjectPage = service.findByPageInCategory(cid, pageNum, pageSize);
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
}
