package com.tricks4live.services;

import com.tricks4live.entries.Page;
import com.tricks4live.entries.SubjectInfo;
import com.tricks4live.entries.UserSimple;
import com.tricks4live.exception.EmailNotVerifiedException;
import com.tricks4live.exception.PermissionException;

public interface ISubjectService {

    SubjectInfo findById(Long subjectId, Long userId);

    Page<SubjectInfo> findByPageInCategory(Long catId, Long pageNum, Integer pageSize);

    Long addSubject(SubjectInfo subject);

    void deleteSubject(Long subjectId);

    Boolean isValidated(Long subjectId, Long userId);

    Long validUser(Long subjectId, Long userId, Boolean valid) throws EmailNotVerifiedException;

    Page<UserSimple> findValidUsersByPage(Long subjectId, Long pageNum, Integer pageSize);

    Boolean isInvalidated(Long subjectId, Long userId);

    Long invalidUser(Long subjectId, Long userId, Boolean invalid) throws EmailNotVerifiedException;

    Page<UserSimple> findInvalidUsersByPage(Long subjectId, Long pageNum, Integer pageSize);

    Long addVerifier(Long subjectId, Long userId) throws PermissionException;

    Long updateVerifier(Long subjectId, Long userId, Boolean valid);

    Page<UserSimple> findVerifierByPage(Long subjectId, Long pageNum, Integer pageSize);

    Boolean isCollected(Long subjectId, Long userId);

    Long collectSubject(Long subjectId, Long userId, Boolean collected) throws EmailNotVerifiedException;

    Page<SubjectInfo> findCollectedByPage(Long userId, Long pageNum, Integer pageSize);

    Page<SubjectInfo> findByPageForNewest(Long pageNum, Integer pageSize);

    Page<SubjectInfo> findUserPublishByPage(Long userId, Long pageNum, Integer pageSize);
}
