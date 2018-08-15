package com.tricks4live;

import com.tricks4live.enrties.Label;
import com.tricks4live.enrties.Pair;
import com.tricks4live.enrties.Subject;
import com.tricks4live.services.ISubjectService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.Arrays;
import java.util.List;

public class SubjectTests extends BaseTest {
    @Autowired
    ISubjectService service;

    @Test
    public void testAddSubject() {
        Subject subject = new Subject("TestSub", "cid_0", "uid_1",
                "开机按贷款纠纷那可就放那看见你发空间阿卡纳地方看见爱的开发可不多见akdjfkanfkja");
        Label[] labels = {new Label("啊啊", "aa"), new Label("版本", "bb")};
        subject.setLabels(labels);
        String[] pics = {"pic1", "pic2"};
        subject.setPicUrls(pics);
        Pair<String, String>[] valids = new Pair[]{new Pair<>("uid1", "uavatar1"), new Pair<>("uid2", "uavatar2")};
        subject.setValidUsers(valids);
        service.addSubject(subject);
    }

    @Test
    public void testAddValid() {
        Subject subject = service.findById("5b73fb53bece4658c984e3b0");
        assert subject != null;
        Pair<String, String> pair = new Pair<>("uid3", "uavatar3");
        Pair<String, String>[] validUsers = subject.getValidUsers();
        Pair<String, String>[] validUsersNew = null;
        if (validUsers == null || validUsers.length == 0) {
            validUsersNew = new Pair[]{pair};
        } else {
            validUsersNew = Arrays.copyOf(validUsers, validUsers.length + 1);
            validUsersNew[validUsers.length] = pair;
        }
        subject.setValidUsers(validUsersNew);
        service.updateSubject(subject);
    }

    @Test
    public void testFind() {
        Page<Subject> subjectPage = service.findByPageWithCid("cid_0", 0, 10);
        assert subjectPage != null;
        println(subjectPage.getTotalElements() + "");
        List<Subject> subjects = subjectPage.getContent();
        for (Subject subject : subjects) {
            println(subject.toString());
        }
    }
}
