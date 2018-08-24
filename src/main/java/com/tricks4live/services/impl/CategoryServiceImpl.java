package com.tricks4live.services.impl;

import com.tricks4live.LogAbleClass;
import com.tricks4live.entries.Category;
import com.tricks4live.exception.DataIntegrityException;
import com.tricks4live.mappers.CategoryMapper;
import com.tricks4live.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CategoryServiceImpl extends LogAbleClass implements ICategoryService {
    @Autowired
    CategoryMapper mapper;

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
    public List<Category> findSubCategory(Long superId) {
        if (StringUtils.isEmpty(superId)) {
            return findByLevel(1);
        } else {
            return mapper.findBySupperId(superId);
        }
    }

    @Override
    public Long addCategory(Category category) {
        mapper.addCategory(category);
        return category.getId();
    }

    @Override
    public void updateCategory(Category category) {
        mapper.updateCategory(category);
    }

    @Override
    public void deleteCategory(Category category) throws DataIntegrityException {
        List<Category> subCat = mapper.findBySupperId(category.getSuperId());
        if (subCat != null && !subCat.isEmpty()) {
            throw new DataIntegrityException();
        }
        mapper.deleteById(category.getId());
    }

    @Override
    public void deleteById(Long cId) throws DataIntegrityException {
        if (!StringUtils.isEmpty(cId)) {
            List<Category> subCat = mapper.findBySupperId(cId);
            if (subCat != null && !subCat.isEmpty()) {
                throw new DataIntegrityException();
            }
            mapper.deleteById(cId);
        }
    }
}
