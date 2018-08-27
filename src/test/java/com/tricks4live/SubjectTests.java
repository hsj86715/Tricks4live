package com.tricks4live;

import com.tricks4live.entries.Label;
import com.tricks4live.entries.Page;
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
        Random random = new Random();
//        for (int i = 0; i < 100; i++) {
            Subject subject = new Subject("TestSub", 289L, 1L,
                    "开机按贷款纠纷那可就放那看见你发空间阿卡" + random.nextInt(100) + random.nextInt(9999));
            List<Label> labels = labelService.findAll();
            int size = random.nextInt(9) + 1;
            int start = random.nextInt(100 - size);
            println("testAddSubject", labels);
            subject.setLabels(labels.subList(start, start + size));
            List<String> pics = new ArrayList<>();
            pics.add("pic1akdjfkdjfkladjfl" + size + start);
            pics.add("pic2akjdfaldjflakfalfanldfklk" + size + start);
            subject.setPicUrls(pics);
            service.addSubject(subject);
//        }
    }

    @Test
    public void testFindById() {
        Subject subject = service.findById(2L);
        println("testFindById", subject);
    }

    @Test
    public void testFindByPage() {
        Page<Subject> subjectPage = service.findByPageInCategory(289L, 2L, 5);
        assert subjectPage != null;
        List<Subject> subjects = subjectPage.getContentResults();
        for (Subject subject : subjects) {
            println(subject.toString());
        }
    }
}
