package com.tricks4live;

import com.tricks4live.enrties.Label;
import com.tricks4live.services.ILabelService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LabelTests extends BaseTest {
    @Autowired
    ILabelService service;

    @Test
    public void testAddLabel() {
        Label label = new Label("标签1", "Label1");
        service.addLabel(label);
    }

    @Test
    public void testUpdateLabel() {
        Label label = service.findById("5b73e0d7bece4633e0570239");
        assert label != null;
        label.setNameCN("标签1+");
        label.setNameEN("Label1+");
        service.updateLabel(label);
    }
}
