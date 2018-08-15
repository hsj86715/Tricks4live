package com.tricks4live.services;

import com.tricks4live.enrties.Subject;
import org.springframework.data.domain.Page;

import java.util.NoSuchElementException;

public interface ISubjectService {

    Subject findById(String id) throws NoSuchElementException;

    Page<Subject> findByPageWithCid(String cid, Integer page, Integer pageSize);

    void addSubject(Subject subject);

    void updateSubject(Subject subject);
}
