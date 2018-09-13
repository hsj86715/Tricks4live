package com.tricks4live.services.impl;

import com.tricks4live.LogAbleClass;
import com.tricks4live.entries.Category;
import com.tricks4live.exception.DataIntegrityException;
import com.tricks4live.mappers.CategoryMapper;
import com.tricks4live.services.ICategoryService;
import com.tricks4live.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl extends LogAbleClass implements ICategoryService {
    @Autowired
    private CategoryMapper mapper;

    @Autowired
    private RedisUtil<Category> redisUtil;

    @Override
    public List<Category> findByLevel(Integer level) {
        String key = "CategoryServiceImpl-findByLevel-" + level;
        if (redisUtil.hasKey(key)) {
            println("redisUtil.hasKey(key)");
            return redisUtil.lGet(key, 0, redisUtil.lGetListSize(key));
        }
        if (level == null || level == 0) {
            level = 1;
        }
        List<Category> categories = mapper.findByLevel(level);
        redisUtil.lSet(key, categories, 60);
        println("findByLevel", categories);
        return categories;
    }

    @Override
    public List<Category> findSubCategory(Long catId) {
        if (catId == null || catId == 0) {
            return findByLevel(1);
        } else {
            String key = "CategoryServiceImpl-findSubCategory-" + catId;
            if (redisUtil.hasKey(key)) {
                println("redisUtil.hasKey(key)");
                return redisUtil.lGet(key, 0, redisUtil.lGetListSize(key));
            }
            List<Category> categories = mapper.findSubCategory(catId);
            redisUtil.lSet(key, categories, 60);
            println("findSubCategory", categories);
            return categories;
        }
    }

    @Override
    public Long addCategory(Category category) {
        category.setCreateDate(new Date());
        mapper.addCategory(category);
        println(category.toString());
        redisUtil.clear();
        return category.getId();
    }

    @Override
    public void updateCategory(Category category) {
        category.setUpdateDate(new Date());
        mapper.updateCategory(category);
        redisUtil.clear();
    }

    @Override
    public void deleteById(Long catId) throws DataIntegrityException {
        if (!StringUtils.isEmpty(catId)) {
            List<Category> subCat = mapper.findSubCategory(catId);
            if (subCat != null && !subCat.isEmpty()) {
                throw new DataIntegrityException();
            }
            mapper.deleteById(catId);
            redisUtil.clear();
        }
    }
}
