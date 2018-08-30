package com.tricks4live.services.impl;

import com.tricks4live.LogAbleClass;
import com.tricks4live.entries.ContentPraise;
import com.tricks4live.entries.Page;
import com.tricks4live.entries.UserSimple;
import com.tricks4live.mappers.PraiseMapper;
import com.tricks4live.vo.PraiseVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class PraiseAbleService extends LogAbleClass {
    @Autowired
    PraiseMapper praiseMapper;

    Long setPraised(ContentPraise praise, Boolean praised) {
        ContentPraise praiseTemp = praiseMapper.findPraise(praise);
        if (praiseTemp == null) {
            if (praised) {
                praise.setPraised(true);
            } else {
                praise.setPraised(null);
            }
            praise.setCreateDate(new Date());
            praiseMapper.addPraise(praise);
            return praise.getId();
        } else {
            if (praised != praiseTemp.getPraised()) {
                if (praised) {
                    praiseTemp.setPraised(true);
                } else {
                    praiseTemp.setPraised(null);
                }
                praiseTemp.setUpdateDate(new Date());
                praiseMapper.updatePraise(praiseTemp);
                return praiseTemp.getId();
            }
        }
        return -1L;
    }

    Page<UserSimple> findUsersByPage(PraiseVO vo, Long pageNum, Integer pageSize) {
        Long pageIdx = pageNum - 1;
        if (pageIdx < 0) {
            pageIdx = 0L;
        }
        vo.setLimitOff(pageIdx * pageSize);
        vo.setLimitRows(pageSize);

        Long totalCount = praiseMapper.getPraiseCount(vo);
        List<UserSimple> result = praiseMapper.findPraiseUserByPage(vo);

        Page<UserSimple> praiseOrTreadPage = new Page<>();
        praiseOrTreadPage.setPageNum(pageNum);
        praiseOrTreadPage.setPageSize(pageSize);
        praiseOrTreadPage.setContentResults(result);
        praiseOrTreadPage.setTotalCount(totalCount);
        return praiseOrTreadPage;
    }
}
