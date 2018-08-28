package com.tricks4live.mappers;

import com.tricks4live.entries.Comment;
import com.tricks4live.vo.CommentVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {
    void addComment(Comment comment);

    Long getCountInSubject(Long subjectId);

    List<Comment> findByPageInSubject(CommentVO vo);

    Comment findSuperComment(Long superId);

    Comment findSubComment(Long commId);
}
