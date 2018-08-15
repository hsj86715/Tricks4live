package com.tricks4live.services.impl;

import com.tricks4live.enrties.Comment;
import com.tricks4live.enrties.Pair;
import com.tricks4live.services.ICommentService;

import java.util.List;

public class CommentServiceImpl implements ICommentService {
    @Override
    public List<Comment> findCommentBySid(String sid) {
        return null;
    }

    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public void addAgreeUser(String cid, Pair<String, String> agree) {

    }

    @Override
    public void removeAgreeUser(String cid, Pair<String, String> agree) {

    }
}
