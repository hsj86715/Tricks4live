package com.tricks4live.services;

import com.tricks4live.entries.Label;

import java.util.List;

public interface ILabelService {
    List<Label> findAll();

    Long addLabel(Label label);

    void updateLabel(Label label);

    Label findById(Long labelId);
}
