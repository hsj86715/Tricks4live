//package com.tricks4live.services.impl;
//
//import com.tricks4live.entries.Comment;
//import com.tricks4live.entries.Pair;
//import com.tricks4live.repositories.CommentRepository;
//import com.tricks4live.services.ICommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.*;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//@Service
//public class CommentServiceImpl extends BaseService implements ICommentService {
//    @Autowired
//    CommentRepository repository;
//
//    @Override
//    protected Class getClazz() {
//        return Comment.class;
//    }
//
//    @Override
//    public Page<Comment> findBySidWithPage(String sid, Integer page, Integer pageSize) {
//        Comment comment = new Comment();
//        comment.setSid(sid);
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withMatcher("sid", ExampleMatcher.GenericPropertyMatchers.exact())
//                .withMatcher("superId", ExampleMatcher.GenericPropertyMatchers.exact());
//        Example<Comment> example = Example.of(comment, matcher);
//        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.DESC, "commentTime");
//        Page<Comment> commentPage = repository.findAll(example, pageable);
//        if (commentPage.getContent() != null) {
//            List<Comment> comments = commentPage.getContent();
//            for (Comment com : comments) {
//                String id = com.getId();
//                Comment follow = null;
//                while ((follow = getCommentFollow(id)) != null) {
//                    System.out.println(follow.toString());
//                    com.setFollow(follow);
//                    com = follow;
//                    id = follow.getId();
//                }
//            }
//        }
//        return commentPage;
//    }
//
//    private Comment getCommentFollow(String cid) {
//        return repository.findBySuperId(cid);
//    }
//
//    @Override
//    public Comment addComment(Comment comment) {
//        comment.setCommentTime(new Date());
//        return repository.insert(comment);
//    }
//
//    @Override
//    public long addAgree(String cid, Pair<String, String> pair) throws NoSuchElementException, IllegalArgumentException {
//        Comment comment = repository.findById(cid).get();
//        List<Pair<String, String>> agreeUsers = comment.getAgreeUsers();
//        if (agreeUsers == null) {
//            agreeUsers = new ArrayList<>();
//        } else {
//            if (agreeUsers.contains(pair)) {
//                throw new IllegalArgumentException("The user is already in the agree users.");
//            }
//        }
//        agreeUsers.add(pair);
//        return modify(cid, agreeUsers, "agree_users");
//    }
//
//    @Override
//    public long removeAgree(String cid, Pair<String, String> pair) throws NoSuchElementException, IllegalArgumentException {
//        Comment comment = repository.findById(cid).get();
//        List<Pair<String, String>> agreeUsers = comment.getAgreeUsers();
//        if (agreeUsers == null) {
//            return 0;
//        }
//        int index = agreeUsers.indexOf(pair);
//        if (index < 0) {
//            throw new IllegalArgumentException("The user is not in the agree users.");
//        }
//        if (agreeUsers.size() == 1) {
//            return modify(cid, null, "agree_users");
//        }
//        agreeUsers.remove(pair);
//        return modify(cid, agreeUsers, "agree_users");
//    }
//
//    @Override
//    public void fellowComment(String cid, Comment comment) throws NoSuchElementException {
//        Comment superCom = repository.findById(cid).get();
//        comment.setSuperId(cid);
//        comment.setFloor(superCom.getFloor() + 1);
//        comment = addComment(comment);
////        modify(cid, comment, "append_fellow");
//    }
//}
