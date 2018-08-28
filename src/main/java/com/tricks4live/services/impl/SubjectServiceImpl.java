package com.tricks4live.services.impl;

import com.tricks4live.LogAbleClass;
import com.tricks4live.annotation.PraiseType;
import com.tricks4live.entries.ContentPraise;
import com.tricks4live.entries.Page;
import com.tricks4live.entries.Subject;
import com.tricks4live.mappers.PraiseMapper;
import com.tricks4live.mappers.SubjectMapper;
import com.tricks4live.services.ISubjectService;
import com.tricks4live.vo.PraiseVO;
import com.tricks4live.vo.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SubjectServiceImpl extends LogAbleClass implements ISubjectService {
    @Autowired
    SubjectMapper mapper;
    @Autowired
    PraiseMapper praiseMapper;

    @Override
    public Subject findById(Long subjectId) {
        Subject subject = mapper.findById(subjectId);
        PraiseVO praiseVO = new PraiseVO(subjectId, PraiseType.PRAISE_TREAD, true);
        subject.setValidCount(Math.toIntExact(praiseMapper.getPraiseUserCount(praiseVO)));
        praiseVO.setPraised(false);
        subject.setInvalidCount(Math.toIntExact(praiseMapper.getPraiseUserCount(praiseVO)));
        return subject;
    }

    @Override
    public Page<Subject> findByPageInCategory(Long catId, Long pageNum, Integer pageSize) {
        if (catId == null || catId == 0) {
            return null;
        }
        SubjectVO vo = new SubjectVO();
        vo.setCategoryId(catId);
        Long pageIdx = pageNum - 1;
        if (pageIdx < 0) {
            pageIdx = 0L;
        }
        vo.setLimitOff(pageIdx * pageSize);
        vo.setLimitRows(pageSize);

        Long totalCount = mapper.getCountInCategory(catId);
        List<Subject> result = mapper.findByPageInCategory(vo);

        Page<Subject> subjectPage = new Page<>();
        subjectPage.setPageNum(pageNum);
        subjectPage.setPageSize(pageSize);
        subjectPage.setContentResults(result);
        subjectPage.setTotalCount(totalCount);
        return subjectPage;
    }


    private Long addPicture(SubjectVO subjectVO) {
        mapper.addPicture(subjectVO);
        return subjectVO.getId();
    }

    private Long addLabel(SubjectVO subjectVO) {
        mapper.addLabel(subjectVO);
        return subjectVO.getId();
    }

    @Override
    public Long addSubject(Subject subject) {
        Date date = new Date();
        subject.setCreateDate(date);
        subject.setUpdateDate(date);
        mapper.addSubject(subject);
        Long sid = subject.getId();
        SubjectVO subjectVO = null;
        if (subject.getLabels() != null) {
            subjectVO = new SubjectVO();
            subjectVO.setId(sid);
            subjectVO.setLabelList(subject.getLabels());
            addLabel(subjectVO);
        }
        if (subject.getPicUrls() != null) {
            subjectVO = new SubjectVO();
            subjectVO.setId(sid);
            subjectVO.setPicturePaths(subject.getPicUrls());
            addPicture(subjectVO);
        }
        println(subject.toString());
        return sid;
    }

    @Override
    public Long validUser(Long subjectId, Long userId, Boolean valid) {
        ContentPraise praise = new ContentPraise(userId, subjectId, PraiseType.PRAISE_TREAD);

        ContentPraise praiseTem = praiseMapper.findPraise(praise);
        if (praiseTem == null) {
            if (valid) {
                praise.setPraised(valid);
            } else {
                praise.setPraised(null);
            }
            praise.setCreateDate(new Date());
            praiseMapper.addPraise(praise);
            return praise.getId();
        } else {
            if (valid != praiseTem.getPraised()) {
                if (valid) {
                    praiseTem.setPraised(valid);
                } else {
                    praiseTem.setPraised(null);
                }
                praiseTem.setUpdateDate(new Date());
                praiseMapper.updatePraise(praiseTem);
                return praiseTem.getId();
            }
        }
        return -1L;
    }

    @Override
    public Page<ContentPraise> findValidUsersByPage(Long subjectId, Long pageNum, Integer pageSize) {
        if (subjectId == null || subjectId == 0) {
            return null;
        }
        PraiseVO vo = new PraiseVO(subjectId, PraiseType.PRAISE_TREAD, true);
        Long pageIdx = pageNum - 1;
        if (pageIdx < 0) {
            pageIdx = 0L;
        }
        vo.setLimitOff(pageIdx * pageSize);
        vo.setLimitRows(pageSize);

        return findUsersByPage(vo, pageNum, pageSize);
    }

    @Override
    public Long invalidUser(Long subjectId, Long userId, Boolean invalid) {
        ContentPraise praise = new ContentPraise(userId, subjectId, PraiseType.PRAISE_TREAD);

        ContentPraise praiseTem = praiseMapper.findPraise(praise);
        if (praiseTem == null) {
            if (invalid) {
                praise.setPraised(false);
            } else {
                praise.setPraised(null);
            }
            praise.setCreateDate(new Date());
            praiseMapper.addPraise(praise);
            return praise.getId();
        } else {
            if (invalid != praiseTem.getPraised()) {
                if (invalid) {
                    praiseTem.setPraised(false);
                } else {
                    praiseTem.setPraised(null);
                }
                praiseTem.setUpdateDate(new Date());
                praiseMapper.updatePraise(praiseTem);
                return praiseTem.getId();
            }
        }
        return -1L;
    }

    @Override
    public Page<ContentPraise> findInvalidUsersByPage(Long subjectId, Long pageNum, Integer pageSize) {
        if (subjectId == null || subjectId == 0) {
            return null;
        }
        PraiseVO vo = new PraiseVO(subjectId, PraiseType.PRAISE_TREAD, false);
        Long pageIdx = pageNum - 1;
        if (pageIdx < 0) {
            pageIdx = 0L;
        }
        vo.setLimitOff(pageIdx * pageSize);
        vo.setLimitRows(pageSize);

        return findUsersByPage(vo, pageNum, pageSize);
    }

    private Page<ContentPraise> findUsersByPage(PraiseVO vo, Long pageNum, Integer pageSize) {
        Long totalCount = praiseMapper.getPraiseUserCount(vo);
        List<ContentPraise> result = praiseMapper.findPraiseUserByPage(vo);

        Page<ContentPraise> praiseOrTreadPage = new Page<>();
        praiseOrTreadPage.setPageNum(pageNum);
        praiseOrTreadPage.setPageSize(pageSize);
        praiseOrTreadPage.setContentResults(result);
        praiseOrTreadPage.setTotalCount(totalCount);
        return praiseOrTreadPage;
    }

    @Override
    public Long addVerifier(Long subjectId, Long userId) {
        ContentPraise praise = new ContentPraise(userId, subjectId, PraiseType.VERIFY_SUBJECT);
        praise.setCreateDate(new Date());
        praiseMapper.addPraise(praise);
        return praise.getId();
    }

    @Override
    public Long updateVerifier(Long subjectId, Long userId, Boolean valid) {
        return null;
    }

    @Override
    public Page<ContentPraise> findVerifierByPage(Long subjectId, Long pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public Long deleteSubject(Long subjectId) {
        return 0L;
    }

}
