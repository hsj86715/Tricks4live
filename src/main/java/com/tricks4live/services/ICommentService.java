package com.tricks4live.services;

import com.tricks4live.entries.Comment;
import com.tricks4live.entries.Page;

public interface ICommentService {

    Page<Comment> findByPageInSubject(Long subjectId, Long pageNum, Integer pageSize);

    Long addComment(Comment comment);

    Long agreeComment(Long commentId, Long userId, Boolean agreement);
}
