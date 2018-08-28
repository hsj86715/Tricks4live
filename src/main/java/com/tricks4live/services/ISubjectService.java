package com.tricks4live.services;

import com.tricks4live.entries.ContentPraise;
import com.tricks4live.entries.Page;
import com.tricks4live.entries.Subject;

public interface ISubjectService {

    Subject findById(Long subjectId);

    Page<Subject> findByPageInCategory(Long catId, Long pageNum, Integer pageSize);

    Long addSubject(Subject subject);

    Long deleteSubject(Long subjectId);

    Long validUser(Long subjectId, Long userId, Boolean valid);

    Page<ContentPraise> findValidUsersByPage(Long subjectId, Long pageNum, Integer pageSize);

    Long invalidUser(Long subjectId, Long userId, Boolean invalid);

    Page<ContentPraise> findInvalidUsersByPage(Long subjectId, Long pageNum, Integer pageSize);

    Long addVerifier(Long subjectId, Long userId);

    Long updateVerifier(Long subjectId, Long userId, Boolean valid);

    Page<ContentPraise> findVerifierByPage(Long subjectId, Long pageNum, Integer pageSize);
}
