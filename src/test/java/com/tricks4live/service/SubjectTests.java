package com.tricks4live.service;

import com.google.gson.Gson;
import com.tricks4live.LogAbleClass;
import com.tricks4live.annotation.ContentType;
import com.tricks4live.entries.Label;
import com.tricks4live.entries.Page;
import com.tricks4live.Steps;
import com.tricks4live.entries.Subject;
import com.tricks4live.entries.SubjectInfo;
import com.tricks4live.services.ILabelService;
import com.tricks4live.services.ISubjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubjectTests extends LogAbleClass {
    @Autowired
    ISubjectService service;
    @Autowired
    ILabelService labelService;

    @Test
    public void testAddSubject() {
//        Random random = new Random();
//        for (int i = 0; i < 100; i++) {
//        SubjectInfo subject = new SubjectInfo("TestSub", 289L, 1L,
//                "开机按贷款纠纷那可就放那看见你发空间阿卡" + random.nextInt(100) + random.nextInt(9999));
//        subject.setTitle("TestSub");
//        List<Label> labels = labelService.findAll();
//        int size = random.nextInt(9) + 1;
//        int start = random.nextInt(100 - size);
//        println("testAddSubject", labels);
//        subject.setCoverPicture("cover_picture_akndfkjankfankf" + size + start);
//        subject.setContentType(ContentType.STEP);
//        List<Steps> stepsList = new ArrayList<>();
//        Steps steps = new Steps();
//        steps.setOperation("Step1:aknfaknfkanfafn");
//        steps.setPicture("Step1_picture_laknkfankdlkad");
//        steps.setTimeCosts(3);
//        stepsList.add(steps);
//
//        steps = new Steps();
//        steps.setOperation("Step2:aknfaknfkanfafn");
//        steps.setPicture("Step2_picture_laknkfankdlkad");
//        steps.setTimeCosts(5);
//        stepsList.add(steps);
//        subject.setOperateSteps(new Gson().toJson(stepsList));
//        service.addSubject(subject);
//        }
    }

    @Test
    public void testFindById() {
        SubjectInfo subject = service.findById(17L);
        println("testFindById", subject);
    }

    @Test
    public void testFindByPage() {
        Page<SubjectInfo> subjectPage = service.findByPageInCategory(289L, 2L, 5);
        assert subjectPage != null;
        println(subjectPage.toString());
        List<SubjectInfo> subjects = subjectPage.getContentResults();
        for (SubjectInfo subject : subjects) {
            println(subject.toString());
        }
    }

    @Test
    public void testFindNewest() {
        Page<SubjectInfo> subjectPage = service.findByPageForNewest(1L, 5);
        assert subjectPage != null;
        println(subjectPage.toString());
    }
}
