package com.tricks4live.mappers;

import com.tricks4live.entries.Subject;
import com.tricks4live.vo.PraiseVO;
import com.tricks4live.vo.SubjectVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SubjectMapper {

    Subject findById(Long subjectId);

    void addPicture(SubjectVO subjectVO);

    void addLabel(SubjectVO subjectVO);

    void addSubject(Subject subject);

    void deleteSubject(Long subjectId);

    List<Subject> findByPageInCategory(SubjectVO subjectVO);

    Long getCountInCategory(Long catId);

    List<Subject> findCollectedByPage(PraiseVO praiseVO);
}
