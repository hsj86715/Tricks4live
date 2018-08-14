package com.tricks4live.services.impl;

import com.tricks4live.enrties.Category;
import com.tricks4live.exception.DataIntegrityException;
import com.tricks4live.repositories.CategoryRepository;
import com.tricks4live.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    CategoryRepository repository;

    @Override
    public List<Category> findCategoryByLevel(Integer level) {
        if (level == null || level == 0) {
            level = 1;
        }
        return repository.findByLevel(level);
    }

    @Override
    public List<Category> findSubCategory(String superId) {
        if (StringUtils.isEmpty(superId)) {
            return repository.findByLevel(1);
        } else {
            return repository.findBySuperId(superId);
        }
    }

    @Override
    public void addCategory(Category category) {
        repository.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        repository.save(category);
    }

    @Override
    public void deleteCategory(Category category) throws DataIntegrityException {
        List<Category> subCat = repository.findBySuperId(category.getcId());
        if (subCat != null && !subCat.isEmpty()) {
            throw new DataIntegrityException();
        }
        repository.delete(category);
    }

    @Override
    public void deleteCategoryById(String cId) throws DataIntegrityException {
        if (!StringUtils.isEmpty(cId)) {
            List<Category> subCat = repository.findBySuperId(cId);
            if (subCat != null && !subCat.isEmpty()) {
                throw new DataIntegrityException();
            }
            repository.deleteById(cId);
        }
    }
}
