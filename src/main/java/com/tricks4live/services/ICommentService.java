package com.tricks4live.services;

import com.tricks4live.entries.Comment;
import com.tricks4live.entries.Page;

public interface ICommentService {

    Page<Comment> findByPageInSubject(Long subjectId, Long pageNum, Integer pageSize);

    Long addComment(Comment comment);

//    long addAgree(String cid, Pair<String, String> pair) throws NoSuchElementException, IllegalArgumentException;
//
//    long removeAgree(String cid, Pair<String, String> pair) throws NoSuchElementException, IllegalArgumentException;

//    Long fellowComment(Comment comment);
}
