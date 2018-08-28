package com.tricks4live.mappers;

import com.tricks4live.entries.Label;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LabelMapper {
    List<Label> findAll();

    void addLabel(Label label);

    void updateLabel(Label label);

    Label findById(Long labelId);
}
