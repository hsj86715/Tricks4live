package com.tricks4live.services.impl;

import com.tricks4live.annotation.PraiseType;
import com.tricks4live.entries.Comment;
import com.tricks4live.entries.ContentPraise;
import com.tricks4live.entries.Page;
import com.tricks4live.mappers.CommentMapper;
import com.tricks4live.services.ICommentService;
import com.tricks4live.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl extends PraiseAbleService implements ICommentService {
    @Autowired
    private CommentMapper mapper;

    @Override
    public Page<Comment> findByPageInSubject(Long subjectId, Long pageNum, Integer pageSize) {
        if (subjectId == null || subjectId == 0) {
            return null;
        }
        CommentVO vo = new CommentVO();
        vo.setSubjectId(subjectId);
        Long pageIdx = pageNum - 1;
        if (pageIdx < 0) {
            pageIdx = 0L;
        }
        vo.setLimitOff(pageIdx * pageSize);
        vo.setLimitRows(pageSize);

        Long totalCount = mapper.getCountInSubject(subjectId);
        List<Comment> result = mapper.findByPageInSubject(vo);
        for (Comment comment : result) {
            Comment sub = null;
            while ((sub = mapper.findSubComment(comment.getId())) != null) {
                comment.setFollow(sub);
                comment = sub;
            }
        }

        Page<Comment> pageComments = new Page<>();
        pageComments.setTotalCount(totalCount);
        pageComments.setContentResults(result);
        pageComments.setPageSize(pageSize);
        pageComments.setPageNum(pageNum);
        return pageComments;
    }

    @Override
    public Long addComment(Comment comment) {
        Long superId = comment.getSuperId();
        if (superId != null && superId > 0) {
            Comment superCom = mapper.findSuperComment(superId);
            if (superCom == null) {
                comment.setSuperId(null);
            } else {
                comment.setFloor(superCom.getFloor() + 1);
            }
        }
        comment.setCreateDate(new Date());
        mapper.addComment(comment);
        return comment.getId();
    }

    @Override
    public Long agreeComment(Long commentId, Long userId, Boolean agreement) {
        ContentPraise praise = new ContentPraise(userId, commentId, PraiseType.AGREE_COMMENT);
        return setPraised(praise, agreement);
    }
}
