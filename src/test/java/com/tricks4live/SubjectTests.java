package com.tricks4live;

import com.tricks4live.entries.Label;
import com.tricks4live.entries.Subject;
import com.tricks4live.services.ILabelService;
import com.tricks4live.services.ISubjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubjectTests extends LogAbleClass {
    @Autowired
    ISubjectService service;
    @Autowired
    ILabelService labelService;

    @Test
    public void testAddSubject() {
        Subject subject = new Subject("TestSub", 0L, 0L,
                "开机按贷款纠纷那可就放那看见你发空间阿卡纳地方看见爱的开发可不多见");
        List<Label> labels = labelService.findAll();
        println("testAddSubject", labels);
        subject.setLabels(labels);
        List<String> pics = new ArrayList<>();
        pics.add("pic1");
        pics.add("pic2");
        subject.setPicUrls(pics);
        service.addSubject(subject);
    }

//    @Test
//    public void testAddValid() {
//        String sid = "5b7535b0bece46922927b2b1";
//        Subject subject = service.findById(sid);
//        assert subject != null;
//        Pair<String, String> pair = new Pair<>("uid4", "uavatar4");
//        service.addValidUser(sid, pair);
//    }
//
//    @Test
//    public void testRemoveValid() {
//        String sid = "5b7535b0bece46922927b2b1";
//        Subject subject = service.findById(sid);
//        assert subject != null;
//        Pair<String, String> pair = new Pair<>("uid4", "uavatar4");
//        service.removeValidUser(sid, pair);
//    }
//
//    @Test
//    public void testAddInvalid() {
//        String sid = "5b7535b0bece46922927b2b1";
//        Subject subject = service.findById(sid);
//        assert subject != null;
//        Pair<String, String> pair = new Pair<>("uid4", "uavatar4");
//        service.addInvalidUser(sid, pair);
//    }
//
//    @Test
//    public void testRemoveInvalid() {
//        String sid = "5b7535b0bece46922927b2b1";
//        Subject subject = service.findById(sid);
//        assert subject != null;
//        Pair<String, String> pair = new Pair<>("uid4", "uavatar4");
//        service.removeInvalidUser(sid, pair);
//    }
//
//    @Test
//    public void testAddVerifier() {
//        String sid = "5b7535b0bece46922927b2b1";
//        Subject subject = service.findById(sid);
//        assert subject != null;
//        Pair<String, String> pair = new Pair<>("uid1", "uavatar1");
//        service.addVerifier(sid, pair);
//    }
//
//    @Test
//    public void testFind() {
//        Page<Subject> subjectPage = service.findByPageWithCid("cid_0", 0, 10);
//        assert subjectPage != null;
//        println(subjectPage.getTotalElements() + "");
//        List<Subject> subjects = subjectPage.getContent();
//        for (Subject subject : subjects) {
//            println(subject.toString());
//        }
//    }
}
