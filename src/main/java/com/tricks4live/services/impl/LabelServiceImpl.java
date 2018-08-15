package com.tricks4live.services.impl;

import com.tricks4live.enrties.Label;
import com.tricks4live.repositories.LabelRepository;
import com.tricks4live.services.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LabelServiceImpl implements ILabelService {
    @Autowired
    LabelRepository repository;

    @Override
    public List<Label> findAll() {
        return repository.findAll();
    }

    @Override
    public void addLabel(Label label) {
        repository.insert(label);
    }

    @Override
    public void updateLabel(Label label) {
        repository.save(label);
    }

    @Override
    public Label findById(String id) throws NoSuchElementException {
        return repository.findById(id).get();
    }
}
