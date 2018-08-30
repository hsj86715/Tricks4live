package com.tricks4live.services.impl;

import com.tricks4live.LogAbleClass;
import com.tricks4live.entries.Category;
import com.tricks4live.exception.DataIntegrityException;
import com.tricks4live.mappers.CategoryMapper;
import com.tricks4live.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl extends LogAbleClass implements ICategoryService {
    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<Category> findByLevel(Integer level) {
        if (level == null || level == 0) {
            level = 1;
        }
        List<Category> categories = mapper.findByLevel(level);
        println("findByLevel", categories);
        return categories;
    }

    @Override
    public List<Category> findSubCategory(Long catId) {
        if (catId == null || catId == 0) {
            return findByLevel(1);
        } else {
            return mapper.findSubCategory(catId);
        }
    }

    @Override
    public Long addCategory(Category category) {
        category.setCreateDate(new Date());
        mapper.addCategory(category);
        println(category.toString());
        return category.getId();
    }

    @Override
    public void updateCategory(Category category) {
        category.setUpdateDate(new Date());
        mapper.updateCategory(category);
    }

    @Override
    public void deleteById(Long catId) throws DataIntegrityException {
        if (!StringUtils.isEmpty(catId)) {
            List<Category> subCat = mapper.findSubCategory(catId);
            if (subCat != null && !subCat.isEmpty()) {
                throw new DataIntegrityException();
            }
            mapper.deleteById(catId);
        }
    }
}
