package com.tricks4live.mappers;

import com.tricks4live.entries.Subject;
import com.tricks4live.entries.SubjectInfo;
import com.tricks4live.vo.PageVO;
import com.tricks4live.vo.SubjectVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SubjectMapper {

    SubjectInfo findById(Long subjectId);

    void addLabel(SubjectVO subjectVO);

    void addSubject(Subject subject);

    void deleteSubject(Long subjectId);

    List<SubjectInfo> findByPageInCategory(SubjectVO subjectVO);

    Long getCountInCategory(Long catId);

    List<SubjectInfo> findCollectedByPage(SubjectVO subjectVO);

    Long getCollectedCount(Long userId);

    List<SubjectInfo> findByPageForNewest(PageVO pageVO);

    Long getCount();

    List<SubjectInfo> findByPageForUser(SubjectVO subjectVO);

    Long getUsersCount(Long userId);
}
