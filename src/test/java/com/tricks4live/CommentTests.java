//package com.tricks4live;
//
//import com.tricks4live.entries.Comment;
//import com.tricks4live.services.ICommentService;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//
//public class CommentTests extends BaseTest {
//
//    @Autowired
//    ICommentService service;
//
//    @Test
//    public void testAddComment() {
//        Comment comment = new Comment("sid_0", "uid_007", "牛逼，写得好，这是要逆天");
//        service.addComment(comment);
//    }
//
//    @Test
//    public void testFellowComment() {
//        Comment comment = new Comment("sid_0", "uid_2", "说得好,aaa");
//        service.fellowComment("5b756301bece46d11201ed4d", comment);
//    }
//
//    @Test
//    public void testFind() {
//        Page<Comment> comments = service.findBySidWithPage("sid_0", 0, 15);
//        assert comments != null;
//        println("find: " + comments.getContent());
//    }
//}
