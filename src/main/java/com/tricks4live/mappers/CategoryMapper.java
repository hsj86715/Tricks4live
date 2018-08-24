package com.tricks4live.mappers;

import com.tricks4live.entries.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryMapper {

    List<Category> findByLevel(Integer level);

    List<Category> findBySupperId(Long superId);

    void addCategory(Category category);

    void updateCategory(Category category);

    void deleteById(Long cId);
}
