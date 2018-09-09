package com.tricks4live.services;

import com.tricks4live.entries.Page;
import com.tricks4live.entries.SubjectInfo;
import com.tricks4live.entries.UserSimple;

public interface ISubjectService {

    SubjectInfo findById(Long subjectId);

    Page<SubjectInfo> findByPageInCategory(Long catId, Long pageNum, Integer pageSize);

    Long addSubject(SubjectInfo subject);

    void deleteSubject(Long subjectId);

    Long validUser(Long subjectId, Long userId, Boolean valid);

    Page<UserSimple> findValidUsersByPage(Long subjectId, Long pageNum, Integer pageSize);

    Long invalidUser(Long subjectId, Long userId, Boolean invalid);

    Page<UserSimple> findInvalidUsersByPage(Long subjectId, Long pageNum, Integer pageSize);

    Long addVerifier(Long subjectId, Long userId);

    Long updateVerifier(Long subjectId, Long userId, Boolean valid);

    Page<UserSimple> findVerifierByPage(Long subjectId, Long pageNum, Integer pageSize);

    Long collectSubject(Long subjectId, Long userId, Boolean collected);

    Page<SubjectInfo> findCollectedByPage(Long userId, Long pageNum, Integer pageSize);

    Page<SubjectInfo> findByPageForNewest(Long pageNum, Integer pageSize);

    Page<SubjectInfo> findUserPublishByPage(Long userId, Long pageNum, Integer pageSize);
}
