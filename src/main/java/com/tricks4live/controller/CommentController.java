package com.tricks4live.controller;

import com.tricks4live.annotation.ErrCode;
import com.tricks4live.entries.Comment;
import com.tricks4live.entries.CommentInfo;
import com.tricks4live.entries.Page;
import com.tricks4live.entries.result.BaseResult;
import com.tricks4live.entries.result.DataResult;
import com.tricks4live.services.ICommentService;
import com.tricks4live.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService service;

    @PostMapping(value = "/add", headers = Constants.HEADER, produces = Constants.APPLICATION_JSON)
    @ResponseBody
    public BaseResult addComment(@RequestParam("subject_id") Long subjectId,
                                 @RequestParam("user_id") Long userId,
                                 @RequestParam("content") String content,
                                 @RequestParam(name = "super_id", required = false) Long superId) {
        BaseResult result = new BaseResult();
        if (StringUtils.isEmpty(content)) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.REQUEST_PARAMETER_LOST), "content");
            return result;
        }
        if (subjectId <= 0 || userId <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "subject_id or/and user_id");
        }
        Comment comment;
        if (superId == null || subjectId <= 0) {
            comment = new Comment(subjectId, userId, content);
        } else {
            comment = new Comment(subjectId, userId, content, superId);
        }
        Long id = service.addComment(comment);
        if (id <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.UNKNOWN));
        }
        return result;
    }

    @RequestMapping("/findByPage")
    @ResponseBody
    public DataResult<Page<CommentInfo>> findByPage(@RequestParam("subject_id") Long subjectId,
                                                @RequestParam("page_num") Long pageNum,
                                                @RequestParam(name = "page_size", required = false, defaultValue = "20") Integer pageSize) {
        DataResult<Page<CommentInfo>> result = new DataResult<>();
        if (subjectId <= 0 || pageNum < 1) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "subject_id or/and page_num");
            return result;
        }
        Page<CommentInfo> commentPage = service.findByPageInSubject(subjectId, pageNum, pageSize);
        result.setData(commentPage);
        return result;
    }

    @RequestMapping("/agree")
    @ResponseBody
    public BaseResult agreeComment(@RequestParam("comment_id") Long commentId,
                                   @RequestParam("user_id") Long userId,
                                   @RequestParam("agreement") Boolean agreement) {
        BaseResult result = new BaseResult();
        if (commentId <= 0 || userId <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.ILLEGAL_ARGUMENT), "comment_id or/and user_id");
            return result;
        }
        Long id = service.agreeComment(commentId, userId, agreement);
        if (id <= 0) {
            result.setCodeMsg(Constants.getErrorMsg(ErrCode.UNKNOWN));
        }
        return result;
    }
}
