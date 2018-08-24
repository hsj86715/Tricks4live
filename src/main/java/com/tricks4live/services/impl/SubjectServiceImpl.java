package com.tricks4live.services.impl;

import com.tricks4live.LogAbleClass;
import com.tricks4live.entries.Subject;
import com.tricks4live.mappers.SubjectMapper;
import com.tricks4live.services.ISubjectService;
import com.tricks4live.vo.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SubjectServiceImpl extends LogAbleClass implements ISubjectService {
    @Autowired
    SubjectMapper mapper;

    @Override
    public Subject findById(Long id) {
        return mapper.findById(id);
    }

//    @Override
//    public Page<Subject> findByPageWithCid(String cid, Integer page, Integer pageSize) {
//        Subject subject = new Subject();
//        subject.setCid(cid);
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withMatcher("cid", ExampleMatcher.GenericPropertyMatchers.exact())
//                .withMatcher("visible", ExampleMatcher.GenericPropertyMatchers.exact())
//                .withMatcher("deleted", ExampleMatcher.GenericPropertyMatchers.exact());
//        Example<Subject> example = Example.of(subject, matcher);
//        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.DESC, "last_modify");
//        return repository.findAll(example, pageable);
//    }


    @Override
    public Long addPicture(SubjectVO subjectVO) {
        mapper.addPicture(subjectVO);
        return subjectVO.getId();
    }

    @Override
    public Long addLabel(SubjectVO subjectVO) {
        mapper.addLabel(subjectVO);
        return subjectVO.getId();
    }

    @Override
    public Long addSubject(Subject subject) {
        Date date = new Date();
        subject.setCreateTime(date);
        subject.setLastModify(date);
        mapper.addSubject(subject);
        Long sid = subject.getId();
        SubjectVO subjectVO = null;
        if (subject.getLabels() != null) {
            subjectVO = new SubjectVO();
            subjectVO.setSubjectId(sid);
            subjectVO.setLabelList(subject.getLabels());
            addLabel(subjectVO);
        }
        if (subject.getPicUrls() != null) {
            subjectVO = new SubjectVO();
            subjectVO.setSubjectId(sid);
            subjectVO.setPicturePaths(subject.getPicUrls());
            addPicture(subjectVO);
        }
        return sid;
    }

//    @Override
//    public long addValidUser(String sid, Pair<String, String> pair) throws NoSuchElementException,
//            IllegalArgumentException {
//        Subject subject = findById(sid);
//        List<Pair<String, String>> validUsers = subject.getValidUsers();
//        if (validUsers == null) {
//            validUsers = new ArrayList<>();
//        } else {
//            if (validUsers.contains(pair)) {
//                throw new IllegalArgumentException("The user is already in the valid users.");
//            }
//        }
//        validUsers.add(pair);
//        return modify(sid, validUsers, "valid_users");
//    }
//
//    @Override
//    public long removeValidUser(String sid, Pair<String, String> pair) throws NoSuchElementException,
//            IllegalArgumentException {
//        Subject subject = findById(sid);
//        List<Pair<String, String>> validUsers = subject.getValidUsers();
//        if (validUsers == null) {
//            return 0;
//        }
//        int index = validUsers.indexOf(pair);
//        if (index < 0) {
//            throw new IllegalArgumentException("The user is not in the valid users.");
//        }
//        if (validUsers.size() == 1) {
//            return modify(sid, null, "valid_users");
//        }
//        validUsers.remove(pair);
//        return modify(sid, validUsers, "valid_users");
//    }
//
//    @Override
//    public long addInvalidUser(String sid, Pair<String, String> pair) throws NoSuchElementException,
//            IllegalArgumentException {
//        Subject subject = findById(sid);
//        List<Pair<String, String>> invalidUsers = subject.getInvalidUsers();
//        if (invalidUsers == null) {
//            invalidUsers = new ArrayList<>();
//        } else {
//            if (invalidUsers.contains(pair)) {
//                throw new IllegalArgumentException("The user is already in the invalid users.");
//            }
//        }
//        invalidUsers.add(pair);
//        return modify(sid, invalidUsers, "invalid_users");
//    }
//
//    @Override
//    public long removeInvalidUser(String sid, Pair<String, String> pair) throws NoSuchElementException,
//            IllegalArgumentException {
//        Subject subject = findById(sid);
//        List<Pair<String, String>> invalidUsers = subject.getInvalidUsers();
//        if (invalidUsers == null) {
//            return 0;
//        }
//        int index = invalidUsers.indexOf(pair);
//        if (index < 0) {
//            throw new IllegalArgumentException("The user is not in the valid users.");
//        }
//        if (invalidUsers.size() == 1) {
//            return modify(sid, null, "invalid_users");
//        }
//        invalidUsers.remove(pair);
//        return modify(sid, invalidUsers, "invalid_users");
//    }
//
//    @Override
//    public long addVerifier(String sid, Pair<String, String> pair) throws NoSuchElementException,
//            IllegalArgumentException {
//        Subject subject = findById(sid);
//        List<Pair<String, String>> verifiers = subject.getVerifiers();
//        if (verifiers == null) {
//            verifiers = new ArrayList<>();
//        } else {
//            if (verifiers.contains(pair)) {
//                throw new IllegalArgumentException("The user is already in the verifier users.");
//            }
//        }
//        verifiers.add(pair);
//        return modify(sid, verifiers, "verifiers");
//    }
//
//    @Override
//    public long deleteSubject(String sid) {
//        return delete(sid);
//    }
}
