package com.tricks4live.mappers;

import com.tricks4live.entries.Subject;
import com.tricks4live.vo.SubjectVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SubjectMapper {

    Subject findById(Long id);

    void addPicture(SubjectVO subjectVO);

    void addLabel(SubjectVO subjectVO);

    void addSubject(Subject subject);

    List<Subject> findByPageInCategory(SubjectVO subjectVO);
}
