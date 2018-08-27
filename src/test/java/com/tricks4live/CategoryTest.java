package com.tricks4live;

import com.tricks4live.entries.Category;
import com.tricks4live.services.ICategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTest extends LogAbleClass {
    @Autowired
    ICategoryService service;

    @Test
    public void testAddCategory() {
        for (int i = 0; i < 4; i++) {
            Category category1 = new Category("测试一级分类" + i, "Test 1.st Cat" + i);
            Long l1Id = service.addCategory(category1);
            for (int j = 0; j < 5; j++) {
                Category category2 = new Category("测试二级分类" + j, "Test 2.nd Cat" + j, l1Id, 2);
                Long l2Id = service.addCategory(category2);
                for (int k = 0; k < 6; k++) {
                    Category category3 = new Category("测试三级分类" + k, "Test 3.rd Cat" + k, l2Id, 3);
                    service.addCategory(category3);
                }
            }
        }
    }

    @Test
    public void testFindCategoryByLevel() {
        List<Category> levelCat = service.findByLevel(3);
        assert levelCat != null;
        for (Category category : levelCat) {
            println(category.toString());
        }
    }

    @Test
    public void testFindSubCategory() {
        List<Category> subCat = service.findSubCategory(147L);
        assert subCat != null;
        for (Category category : subCat) {
            println(category.toString());
        }
    }

    @Test
    public void testDeleteCategory() {
        service.deleteById(3L);
    }
}
