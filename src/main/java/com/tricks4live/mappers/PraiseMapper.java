package com.tricks4live.mappers;

import com.tricks4live.entries.ContentPraise;
import com.tricks4live.entries.UserSimple;
import com.tricks4live.vo.PraiseVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PraiseMapper {

    void addPraise(ContentPraise praise);

    void updatePraise(ContentPraise praise);

    ContentPraise findPraise(ContentPraise praise);

    Long getPraiseCount(PraiseVO vo);

    List<UserSimple> findPraiseUserByPage(PraiseVO vo);
}
