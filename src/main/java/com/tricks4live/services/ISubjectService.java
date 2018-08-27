package com.tricks4live.services;

import com.tricks4live.entries.Page;
import com.tricks4live.entries.Subject;
import com.tricks4live.vo.SubjectVO;

public interface ISubjectService {

    Subject findById(Long id);

    Page<Subject> findByPageInCategory(Long cid, Long pageNum, Integer pageSize);

    Long addPicture(SubjectVO subjectVO);

    Long addLabel(SubjectVO subjectVO);

    Long addSubject(Subject subject);
//
//    long addValidUser(String sid, Pair<String, String> pair) throws NoSuchElementException, IllegalArgumentException;
//
//    long removeValidUser(String sid, Pair<String, String> pair) throws NoSuchElementException, IllegalArgumentException;
//
//    long addInvalidUser(String sid, Pair<String, String> pair) throws NoSuchElementException, IllegalArgumentException;
//
//    long removeInvalidUser(String sid, Pair<String, String> pair) throws NoSuchElementException, IllegalArgumentException;
//
//    long addVerifier(String sid, Pair<String, String> pair) throws NoSuchElementException, IllegalArgumentException;
//
//    long deleteSubject(String sid);
}
