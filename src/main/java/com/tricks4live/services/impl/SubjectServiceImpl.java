package com.tricks4live.services.impl;

import com.tricks4live.enrties.Pair;
import com.tricks4live.enrties.Subject;
import com.tricks4live.repositories.SubjectRepository;
import com.tricks4live.services.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;

@Service
public class SubjectServiceImpl implements ISubjectService {
    @Autowired
    SubjectRepository repository;

    @Override
    public Subject findById(String id) throws NoSuchElementException {
        return repository.findById(id).get();
    }

    @Override
    public Page<Subject> findByPageWithCid(String cid, Integer page, Integer pageSize) {
        Subject subject = new Subject();
        subject.setCid(cid);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("cid", ExampleMatcher.GenericPropertyMatchers.exact());
        Example<Subject> example = Example.of(subject, matcher);
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.DESC, "createTime");
        return repository.findAll(example, pageable);
    }

    @Override
    public void addSubject(Subject subject) {
        Date date = new Date();
        subject.setCreateTime(date);
        subject.setLastModify(date);
        repository.insert(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        repository.save(subject);
    }
}
