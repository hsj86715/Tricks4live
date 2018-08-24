//package com.tricks4live.services;
//
//import com.tricks4live.entries.Comment;
//import com.tricks4live.entries.Pair;
//import org.springframework.data.domain.Page;
//
//import java.util.NoSuchElementException;
//
//public interface ICommentService {
//
//    Page<Comment> findBySidWithPage(String sid, Integer page, Integer pageSize);
//
//    Comment addComment(Comment comment);
//
//    long addAgree(String cid, Pair<String, String> pair) throws NoSuchElementException, IllegalArgumentException;
//
//    long removeAgree(String cid, Pair<String, String> pair) throws NoSuchElementException, IllegalArgumentException;
//
//    void fellowComment(String cid, Comment comment) throws NoSuchElementException;
//}
