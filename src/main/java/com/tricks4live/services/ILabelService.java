package com.tricks4live.services;

import com.tricks4live.enrties.Label;

import java.util.List;
import java.util.NoSuchElementException;

public interface ILabelService {
    List<Label> findAll();

    void addLabel(Label label);

    void updateLabel(Label label);

    Label findById(String id) throws NoSuchElementException;
}
