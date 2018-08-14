package com.tricks4live;

import com.tricks4live.enrties.Category;
import com.tricks4live.services.ICategoryService;
import com.tricks4live.utils.UUIDUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryTest extends BaseTest {
    @Autowired
    ICategoryService service;

    @Test
    public void testAddCategory() {
        for (int i = 0; i < 4; i++) {
            String uuid1 = UUIDUtil.getUUID();
            Category category1 = new Category(uuid1, "测试一级分类" + i, "Test 1.st Cat" + i);
            for (int j = 0; j < 5; j++) {
                String uuid2 = UUIDUtil.getUUID();
                Category category2 = new Category(uuid2, "测试二级分类" + j, "Test 2.nd Cat" + j, uuid1, 2);
                for (int k = 0; k < 6; k++) {
                    String uuid3 = UUIDUtil.getUUID();
                    Category category3 = new Category(uuid3, "测试三级分类" + k, "Test 3.rd Cat" + k, uuid2, 3);
                    service.addCategory(category3);
                }
                service.addCategory(category2);
            }
            service.addCategory(category1);
        }
    }

    @Test
    public void testFindCategoryByLevel() {
        List<Category> levelCat = service.findCategoryByLevel(3);
        assert levelCat != null;
        for (Category category : levelCat) {
            println(category.toString());
        }
    }

    @Test
    public void testFindSubCategory() {
        List<Category> subCat = service.findSubCategory("832706E305B6457F8544597B5C9BFD3B");
        assert subCat != null;
        for (Category category : subCat) {
            println(category.toString());
        }
    }

    @Test
    public void testDeleteCategory() {
        service.deleteCategoryById("ECB3CD3EE8494540B933738F983122F9");
    }
}
