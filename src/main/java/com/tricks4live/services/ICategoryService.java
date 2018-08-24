package com.tricks4live.services;

import com.tricks4live.entries.Category;
import com.tricks4live.exception.DataIntegrityException;

import java.util.List;

public interface ICategoryService {
    List<Category> findByLevel(Integer level);

    List<Category> findSubCategory(Long superId);

    Long addCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Category category) throws DataIntegrityException;

    void deleteById(Long cId) throws DataIntegrityException;
}
