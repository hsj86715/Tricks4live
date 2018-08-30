package com.tricks4live.service;

import com.tricks4live.LogAbleClass;
import com.tricks4live.entries.Label;
import com.tricks4live.services.ILabelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LabelTests extends LogAbleClass {
    @Autowired
    ILabelService service;

    @Test
    public void testAddLabel() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int idx = random.nextInt(999);
            Label label = new Label("标签" + idx, "Label" + idx);
            service.addLabel(label);
        }
    }

    @Test
    public void testUpdateLabel() {
        Label label = service.findById(1L);
        assert label != null;
        Random random = new Random();
        int idx = random.nextInt(99);
        label.setNameCN("标签1+" + idx);
        label.setNameEN("Label1+" + idx);
        service.updateLabel(label);
    }

    @Test
    public void testFindAll() {
        List<Label> labelList = service.findAll();
        println("testFindAll", labelList);
    }
}
