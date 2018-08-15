package com.tricks4live.services;

import com.tricks4live.enrties.Comment;
import com.tricks4live.enrties.Pair;

import java.util.List;

public interface ICommentService {

    List<Comment> findCommentBySid(String sid);

    void addComment(Comment comment);

    void addAgreeUser(String cid, Pair<String, String> agree);

    void removeAgreeUser(String cid, Pair<String, String> agree);
}
