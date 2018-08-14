package com.tricks4live.services;

import com.tricks4live.enrties.Category;
import com.tricks4live.exception.DataIntegrityException;

import java.util.List;

public interface ICategoryService {
    List<Category> findCategoryByLevel(Integer level);

    List<Category> findSubCategory(String superId);

    void addCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Category category) throws DataIntegrityException;

    void deleteCategoryById(String cId) throws DataIntegrityException;
}
