package com.tricks4live;

import com.tricks4live.entries.Comment;
import com.tricks4live.entries.Page;
import com.tricks4live.entries.User;
import com.tricks4live.services.ICommentService;
import com.tricks4live.services.ISubjectService;
import com.tricks4live.services.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTests extends LogAbleClass {

    @Autowired
    ICommentService service;
    @Autowired
    IUserService userService;
    @Autowired
    ISubjectService subjectService;

    @Test
    public void testAddComment() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            List<User> users = userService.findAll();
            int userIdx = random.nextInt(users.size());
            Comment comment = new Comment(6L, users.get(userIdx).getId(), "牛逼，写得好，这是要逆天" + random.nextInt(100) + random.nextInt(9999));
            service.addComment(comment);
            println(comment.toString());
        }
    }

    @Test
    public void testFellowComment() {
        Comment comment = new Comment(6L, 1L, "说得好,aaa", 4L);
        service.fellowComment(comment);
        println(comment.toString());
    }

    @Test
    public void testFind() {
        Page<Comment> comments = service.findByPageInSubject(6L, 0L, 15);
        assert comments != null;
        println(comments.toString());
        List<Comment> commentList = comments.getContentResults();
        for (Comment comment : commentList) {
            println(comment.toString());
        }
    }
}
