package com.tricks4live.services.impl;

import com.tricks4live.LogAbleClass;
import com.tricks4live.entries.Label;
import com.tricks4live.mappers.LabelMapper;
import com.tricks4live.services.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class LabelServiceImpl extends LogAbleClass implements ILabelService {
    @Autowired
    private LabelMapper mapper;

    @Override
    public List<Label> findAll() {
        return mapper.findAll();
    }

    @Override
    public Long addLabel(Label label) {
        label.setCreateDate(new Date());
        mapper.addLabel(label);
        return label.getId();
    }

    @Override
    public void updateLabel(Label label) {
        mapper.updateLabel(label);
    }

    @Override
    public Label findById(Long labelId) {
        if (StringUtils.isEmpty(labelId)) {
            return null;
        }
        return mapper.findById(labelId);
    }
}
