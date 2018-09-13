package com.tricks4live.services.impl;

import com.tricks4live.annotation.PraiseType;
import com.tricks4live.entries.ContentPraise;
import com.tricks4live.entries.Page;
import com.tricks4live.entries.SubjectInfo;
import com.tricks4live.entries.UserSimple;
import com.tricks4live.mappers.SubjectMapper;
import com.tricks4live.services.ISubjectService;
import com.tricks4live.vo.PageVO;
import com.tricks4live.vo.PraiseVO;
import com.tricks4live.vo.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SubjectServiceImpl extends PraiseAbleService implements ISubjectService {
    @Autowired
    private SubjectMapper mapper;

    @Override
    public SubjectInfo findById(Long subjectId) {
        return mapper.findById(subjectId);
    }

    @Override
    public Page<SubjectInfo> findByPageInCategory(Long catId, Long pageNum, Integer pageSize) {
        SubjectVO vo = new SubjectVO();
        vo.setCategoryId(catId);
        Long pageIdx = pageNum - 1;
        if (pageIdx < 0) {
            pageIdx = 0L;
        }
        vo.setLimitOff(pageIdx * pageSize);
        vo.setLimitRows(pageSize);

        Long totalCount = mapper.getCountInCategory(catId);
        List<SubjectInfo> result = mapper.findByPageInCategory(vo);

        Page<SubjectInfo> subjectPage = new Page<>();
        subjectPage.setPageNum(pageNum);
        subjectPage.setPageSize(pageSize);
        subjectPage.setContentResults(result);
        subjectPage.setTotalCount(totalCount);
        return subjectPage;
    }

    @Override
    public Page<SubjectInfo> findCollectedByPage(Long userId, Long pageNum, Integer pageSize) {
        SubjectVO subjectVO = new SubjectVO();
        subjectVO.setUserId(userId);
        Long pageIdx = pageNum - 1;
        if (pageIdx < 0) {
            pageIdx = 0L;
        }
        subjectVO.setLimitOff(pageIdx * pageSize);
        subjectVO.setLimitRows(pageSize);

        Long totalCount = mapper.getCollectedCount(userId);
        List<SubjectInfo> result = mapper.findCollectedByPage(subjectVO);

        Page<SubjectInfo> subjectPage = new Page<>();
        subjectPage.setPageNum(pageNum);
        subjectPage.setPageSize(pageSize);
        subjectPage.setContentResults(result);
        subjectPage.setTotalCount(totalCount);
        return subjectPage;
    }

    @Override
    public Page<SubjectInfo> findByPageForNewest(Long pageNum, Integer pageSize) {
        PageVO pageVO = new PraiseVO();
        Long pageIdx = pageNum - 1;
        if (pageIdx < 0) {
            pageIdx = 0L;
        }
        pageVO.setLimitOff(pageIdx * pageSize);
        pageVO.setLimitRows(pageSize);

        Long totalCount = mapper.getCount();
        List<SubjectInfo> result = mapper.findByPageForNewest(pageVO);
        Page<SubjectInfo> subjectPage = new Page<>();
        subjectPage.setPageNum(pageNum);
        subjectPage.setPageSize(pageSize);
        subjectPage.setContentResults(result);
        subjectPage.setTotalCount(totalCount);
        return subjectPage;
    }

    @Override
    public Page<SubjectInfo> findUserPublishByPage(Long userId, Long pageNum, Integer pageSize) {
        SubjectVO subjectVO = new SubjectVO();
        Long pageIdx = pageNum - 1;
        if (pageIdx < 0) {
            pageIdx = 0L;
        }

        subjectVO.setLimitOff(pageIdx * pageSize);
        subjectVO.setLimitRows(pageSize);

        Long totalCount = mapper.getUsersCount(userId);
        List<SubjectInfo> result = mapper.findByPageForUser(subjectVO);
        Page<SubjectInfo> subjectPage = new Page<>();
        subjectPage.setPageNum(pageNum);
        subjectPage.setPageSize(pageSize);
        subjectPage.setContentResults(result);
        subjectPage.setTotalCount(totalCount);
        return subjectPage;
    }

    private Long addLabel(SubjectVO subjectVO) {
        mapper.addLabel(subjectVO);
        return subjectVO.getId();
    }

    @Override
    public Long addSubject(SubjectInfo subject) {
        Date date = new Date();
        subject.setCreateDate(date);
        subject.setUpdateDate(date);
        mapper.addSubject(subject.toSubject());
        Long sid = subject.getId();
        SubjectVO subjectVO = null;
        if (subject.getLabels() != null) {
            subjectVO = new SubjectVO();
            subjectVO.setId(sid);
            subjectVO.setLabelList(subject.getLabels());
            addLabel(subjectVO);
        }
        println(subject.toString());
        return sid;
    }

    @Override
    public Long invalidUser(Long subjectId, Long userId, Boolean invalid) {
        ContentPraise praise = new ContentPraise(userId, subjectId, PraiseType.PRAISE_TREAD);

        ContentPraise praiseTemp = praiseMapper.findPraise(praise);
        if (praiseTemp == null) {
            if (invalid) {
                praise.setPraised(false);
            } else {
                praise.setPraised(null);
            }
            praise.setCreateDate(new Date());
            praiseMapper.addPraise(praise);
            return praise.getId();
        } else {
            if (invalid != praiseTemp.getPraised()) {
                if (invalid) {
                    praiseTemp.setPraised(false);
                } else {
                    praiseTemp.setPraised(null);
                }
                praiseTemp.setUpdateDate(new Date());
                praiseMapper.updatePraise(praiseTemp);
                return praiseTemp.getId();
            }
        }
        return -1L;
    }

    @Override
    public Page<UserSimple> findValidUsersByPage(Long subjectId, Long pageNum, Integer pageSize) {
        if (subjectId == null || subjectId == 0) {
            return null;
        }
        PraiseVO vo = new PraiseVO(subjectId, PraiseType.PRAISE_TREAD, true);
        return findUsersByPage(vo, pageNum, pageSize);
    }

    @Override
    public Page<UserSimple> findInvalidUsersByPage(Long subjectId, Long pageNum, Integer pageSize) {
        if (subjectId == null || subjectId == 0) {
            return null;
        }
        PraiseVO vo = new PraiseVO(subjectId, PraiseType.PRAISE_TREAD, false);
        return findUsersByPage(vo, pageNum, pageSize);
    }

    @Override
    public Page<UserSimple> findVerifierByPage(Long subjectId, Long pageNum, Integer pageSize) {
        if (subjectId == null || subjectId == 0) {
            return null;
        }
        PraiseVO vo = new PraiseVO(subjectId, PraiseType.VERIFY_SUBJECT, false);
        return findUsersByPage(vo, pageNum, pageSize);
    }

    @Override
    public Long addVerifier(Long subjectId, Long userId) {
        ContentPraise praise = new ContentPraise(userId, subjectId, PraiseType.VERIFY_SUBJECT);
        praise.setCreateDate(new Date());
        praiseMapper.addPraise(praise);
        return praise.getId();
    }

    @Override
    public Long validUser(Long subjectId, Long userId, Boolean valid) {
        ContentPraise praise = new ContentPraise(userId, subjectId, PraiseType.PRAISE_TREAD);
        return setPraised(praise, valid);
    }

    @Override
    public Long updateVerifier(Long subjectId, Long userId, Boolean valid) {
        ContentPraise praise = new ContentPraise(userId, subjectId, PraiseType.VERIFY_SUBJECT);
        return setPraised(praise, valid);
    }

    @Override
    public Long collectSubject(Long subjectId, Long userId, Boolean collected) {
        ContentPraise praise = new ContentPraise(userId, subjectId, PraiseType.COLLECT_SUBJECT);
        return setPraised(praise, collected);
    }

    @Override
    public void deleteSubject(Long subjectId) {
        mapper.deleteSubject(subjectId);
    }

}
